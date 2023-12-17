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

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

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
        final List<Apply> allApply = applyRepository.findAll();
        LOGGER.info("{}", allApply);

        final List<ApplyHRResponseDto> collect = allApply.stream()
                .map(apply -> modelMapperConfig.modelMapper()
                        .map(apply, ApplyHRResponseDto.class))
                .collect(Collectors.toList());

        for (var result : collect) {
            final User user = userService.findUserById(result.getUserId());
            result.setUsername(user.getUsername());
            result.setFullName(user.getFullName());
        }

        return collect;
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
        Object result = applyRepository.findJobUserApplied(applyId);

        if (result != null) {
            Object[] resultArray = (Object[]) result;

            ApplyHRDetailResponseDto responseDto = new ApplyHRDetailResponseDto();

            // Assuming the order of elements in the result array is [Apply, Job, User]
            responseDto.setId((String) resultArray[0]);
            responseDto.setApplied((boolean) resultArray[1]);
            responseDto.setStatus(resultArray[2] != null ? (String) resultArray[2] : null);
            responseDto.setInterviewDate(((Date) resultArray[3]).toLocalDate());
            responseDto.setInterviewTime(resultArray[4] != null ? ((java.sql.Time) resultArray[4]).toLocalTime() : null);
            responseDto.setInterviewLink((String) resultArray[5]);

            responseDto.setJobId((String) resultArray[6]);
            responseDto.setTitle((String) resultArray[7]);
            responseDto.setDescription((String) resultArray[8]);
            responseDto.setSortDescription((String) resultArray[9]);
            responseDto.setUploadDate((String) resultArray[10]);
            responseDto.setSalaryForm((String) resultArray[11]);
            responseDto.setSalaryTo((String) resultArray[12]);
            responseDto.setDegreeLevel((String) resultArray[13]);
            responseDto.setWorkTimeType((String) resultArray[14]);
            responseDto.setLocation((String) resultArray[15]);
            responseDto.setWorkLocationType((String) resultArray[16]);
            responseDto.setWorkTimeForm(resultArray[17] != null ? ((java.sql.Time) resultArray[17]).toLocalTime() : null);
            responseDto.setWorkTimeTo(resultArray[18] != null ? ((java.sql.Time) resultArray[18]).toLocalTime() : null);

            responseDto.setUserId((String) resultArray[19]);
            responseDto.setUsername((String) resultArray[20]);
            responseDto.setFullName((String) resultArray[21]);
            responseDto.setEmail((String) resultArray[22]);

            return responseDto;
        } else {
            // Handle the case where the result is null (not found)
            throw new RuntimeException("Apply with ID " + applyId + " not found");
        }
    }

    @Override
    public ApplyJobUserResponseDto HRAppliedJobUser(String applyId, ReplyUserApplyJobDTO replyUserApplyJobDTO) {

        final Apply applyUpdate = applyRepository.findById(applyId).orElseThrow(() -> new RuntimeException("Apply with ID " + applyId + " not found"));
        final Job job = jobRepository.findJobById(applyUpdate.getJob().getId());
        LOGGER.info("{}", job);

        if (!job.getUser().getId().equals(replyUserApplyJobDTO.getUserId())) {
            throw new RuntimeException("You cannot reply to work that was not created by you");
        }

        if (!job.getUser().getRoles().stream().anyMatch(role -> role.getName().equals("HR"))) {
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
