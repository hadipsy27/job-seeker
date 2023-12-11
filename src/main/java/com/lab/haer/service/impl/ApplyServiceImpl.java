package com.lab.haer.service.impl;

import com.lab.haer.config.ModelMapperConfig;
import com.lab.haer.dto.apply.ApplyHRResponseDto;
import com.lab.haer.dto.apply.ApplyUserCreateDto;
import com.lab.haer.dto.JobAllResponseDto;
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
    public List<ApplyUserCreateDto> findAllApplyJob() {
        final List<Apply> allApply = applyRepository.findAll();
        return allApply.stream().map(apply -> modelMapperConfig.modelMapper()
                .map(apply, ApplyUserCreateDto.class)
        ).collect(Collectors.toList());
    }

    @Override
    public List<ApplyHRResponseDto> findJobApplied() {
        return null;
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
}
