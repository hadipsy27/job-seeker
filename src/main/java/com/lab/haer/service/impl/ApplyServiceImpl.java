package com.lab.haer.service.impl;

import com.lab.haer.config.ModelMapperConfig;
import com.lab.haer.dto.JobAllResponseDto;
import com.lab.haer.dto.apply.ApplyHRDetailResponseDto;
import com.lab.haer.dto.apply.ApplyHRResponseDto;
import com.lab.haer.dto.apply.ApplyUserCreateDto;
import com.lab.haer.entity.Apply;
import com.lab.haer.entity.Job;
import com.lab.haer.entity.User;
import com.lab.haer.repository.ApplyRepository;
import com.lab.haer.service.ApplyService;
import com.lab.haer.service.JobService;
import com.lab.haer.service.UserService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    @Override
    public List<ApplyHRResponseDto> findAllApplyJob() {
        final List<Apply> allApply = applyRepository.findAll();
        LOGGER.info("{}", allApply);

        final List<ApplyHRResponseDto> collect = allApply.stream().map(apply -> modelMapperConfig.modelMapper()
                .map(apply, ApplyHRResponseDto.class)).collect(Collectors.toList());

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
            responseDto.setInterviewDate((LocalDate) resultArray[2]);

            // Check for null before converting to LocalTime
            responseDto.setInterviewTime(resultArray[3] != null ? ((java.sql.Time) resultArray[3]).toLocalTime() : null);

            responseDto.setInterviewLink((String) resultArray[4]);

            responseDto.setJobId((String) resultArray[5]);
            responseDto.setTitle((String) resultArray[6]);
            responseDto.setDescription((String) resultArray[7]);
            responseDto.setSortDescription((String) resultArray[8]);
            responseDto.setUploadDate((String) resultArray[9]);
            responseDto.setSalaryForm((String) resultArray[10]);
            responseDto.setSalaryTo((String) resultArray[11]);
            responseDto.setDegreeLevel((String) resultArray[12]);
            responseDto.setWorkTimeType((String) resultArray[13]);
            responseDto.setLocation((String) resultArray[14]);
            responseDto.setWorkLocationType((String) resultArray[15]);

            // Check for null before converting to LocalTime
            responseDto.setWorkTimeForm(resultArray[16] != null ? ((java.sql.Time) resultArray[16]).toLocalTime() : null);
            responseDto.setWorkTimeTo(resultArray[17] != null ? ((java.sql.Time) resultArray[17]).toLocalTime() : null);

            responseDto.setUserId((String) resultArray[18]);
            responseDto.setUsername((String) resultArray[19]);
            responseDto.setFullName((String) resultArray[20]);
            responseDto.setEmail((String) resultArray[21]);

            return responseDto;
        } else {
            // Handle the case where the result is null (not found)
            throw new RuntimeException("Apply with ID " + applyId + " not found");
        }
    }

}
