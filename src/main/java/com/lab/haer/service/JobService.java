package com.lab.haer.service;

import com.lab.haer.dto.JobAllResponseDto;
import com.lab.haer.dto.JobCreateDto;
import com.lab.haer.dto.JobUpdateDto;

import java.util.List;

public interface JobService {

    public JobCreateDto createJob(JobCreateDto jobCreateDto);

    public JobUpdateDto updateJob(String id, JobUpdateDto jobUpdateDto);

    public List<JobAllResponseDto> findAllJob();

    JobAllResponseDto findJobById(String id);

    List<JobAllResponseDto> getJobByUserId(String userId);

}
