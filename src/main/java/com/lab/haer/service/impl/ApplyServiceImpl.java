package com.lab.haer.service.impl;

import com.lab.haer.config.ModelMapperConfig;
import com.lab.haer.dto.JobAllResponseDto;
import com.lab.haer.dto.apply.*;
import com.lab.haer.entity.Apply;
import com.lab.haer.entity.Job;
import com.lab.haer.entity.User;
import com.lab.haer.enums.Status;
import com.lab.haer.repository.ApplyRepository;
import com.lab.haer.repository.JobRepository;
import com.lab.haer.service.ApplyService;
import com.lab.haer.service.JobService;
import com.lab.haer.service.UserService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class ApplyServiceImpl implements ApplyService {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ApplyServiceImpl.class);

    private ApplyRepository applyRepository;
    private ModelMapperConfig modelMapperConfig;
    private JobService jobService;
    private UserService userService;

    private JobRepository jobRepository;

    @Override
    public List<ApplyHRResponseDto> findAllApplyJob() {

        final List<ApplyHRResponseDto> allApply = applyRepository.findAllApply();
        LOGGER.info("{}", allApply);

        if (allApply == null || allApply.isEmpty()) {
            LOGGER.info("No Apply entities found.");
            return Collections.emptyList(); // or throw an exception, depending on your requirements
        }

        return allApply;
    }

    @Override
    public ApplyUserCreateDto createUserApplyJob(ApplyUserCreateDto applyUserCreateDto) {

        Apply apply = new Apply();
        final JobAllResponseDto jobById = jobService.findJobById(applyUserCreateDto.getJobId());
        final Job mapToJob = modelMapperConfig.modelMapper().map(jobById, Job.class);
        LOGGER.info("{}", mapToJob);
        apply.setJob(mapToJob);

        final User getUserById = userService.findUserById(applyUserCreateDto.getUserId());
        LOGGER.info(getUserById.toString());
        apply.setUser(getUserById);

        apply.setApplied(applyUserCreateDto.getApplied());

        final Apply save = applyRepository.save(apply);
        final ApplyUserCreateDto applyMap = modelMapperConfig.modelMapper().map(save, ApplyUserCreateDto.class);
        LOGGER.info("{}", applyMap);
        return applyMap;

    }

    @Override
    public ApplyHRDetailResponseDto findJobUserApplied(String applyId) {
        ApplyHRDetailResponseDto applyHRDetailResponseDto = applyRepository.findJobUserApplied(applyId);
        LOGGER.info("{}", applyHRDetailResponseDto);
        return applyHRDetailResponseDto;
    }

    @Override
    public ApplyJobUserResponseDto HRAppliedJobUser(String applyId, ReplyUserApplyJobDTO replyUserApplyJobDTO) {

        final Apply applyUpdate = applyRepository.findById(applyId).orElseThrow(() -> new RuntimeException("Apply with ID " + applyId + " not found"));
        final Job job = jobRepository.findJobById(applyUpdate.getJob().getId());
        LOGGER.info("{}", job);

        if (!job.getUser().getId().equals(replyUserApplyJobDTO.getUserId())) {
            throw new RuntimeException("You cannot reply to work that was not created by you");
        }

        if (job.getUser().getRoles().stream().noneMatch(role -> role.getName().equals("HR"))) {
            throw new RuntimeException("You can't reply because you not Human Resource");
        }

        applyUpdate.setStatus(Status.valueOf(replyUserApplyJobDTO.getStatus()));
        applyUpdate.setInterviewDate(replyUserApplyJobDTO.getInterviewDate());
        applyUpdate.setInterviewTime(replyUserApplyJobDTO.getInterviewTime());
        applyUpdate.setInterviewLink(replyUserApplyJobDTO.getInterviewLink());

        final Apply save = applyRepository.save(applyUpdate);
        LOGGER.info("{}", save);

        final ApplyJobUserResponseDto result = modelMapperConfig.modelMapper().map(save, ApplyJobUserResponseDto.class);
        result.setTitle(applyUpdate.getJob().getTitle());
        result.setDescription(applyUpdate.getJob().getDescription());
        result.setSortDescription(applyUpdate.getJob().getSortDescription());
        result.setUploadDate(applyUpdate.getJob().getUploadDate());
        result.setSalaryForm(applyUpdate.getJob().getSalaryForm());
        result.setSalaryTo(applyUpdate.getJob().getSalaryTo());
        result.setDegreeLevel(applyUpdate.getJob().getDegreeLevel());
        result.setWorkTimeType(applyUpdate.getJob().getWorkTimeType());
        result.setLocation(applyUpdate.getJob().getLocation());
        result.setWorkLocationType(applyUpdate.getJob().getWorkLocationType());
        result.setWorkTimeForm(applyUpdate.getJob().getWorkTimeForm());
        result.setWorkTimeTo(applyUpdate.getJob().getWorkTimeTo());
        // ---> User Entity <--- \\
        result.setUsername(applyUpdate.getUser().getUsername());
        result.setFullName(applyUpdate.getUser().getFullName());
        result.setEmail(applyUpdate.getUser().getEmail());

        return result;
    }


}
