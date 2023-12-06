package com.lab.haer.service;

import com.lab.haer.dto.JobAllResponseDto;
import com.lab.haer.dto.JobCreateDto;

import java.util.List;

public interface JobService {

    public JobCreateDto createJob(JobCreateDto jobCreateDto);

    public List<JobAllResponseDto> findAllJob();

    JobAllResponseDto findJobById(String id);

}
