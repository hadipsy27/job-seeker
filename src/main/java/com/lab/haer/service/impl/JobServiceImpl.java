package com.lab.haer.service.impl;

import com.lab.haer.dto.JobCreateDto;
import com.lab.haer.entity.Job;
import com.lab.haer.repository.JobRepository;
import com.lab.haer.service.JobService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JobServiceImpl implements JobService {

    private final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(JobServiceImpl.class);

    private JobRepository jobRepository;

    @Override
    public void createJob(JobCreateDto jobCreateDto) {

        Job job = new Job();
        job.setTitle(jobCreateDto.getTitle());
//        job.setCategories(jobDto.getCategories());
        job.setSortDescription(jobCreateDto.getSortDescription());
        job.setDescription(jobCreateDto.getDescription());
//        job.setUser();
        job.setSalaryForm(jobCreateDto.getSalaryForm());
        job.setSalaryTo(jobCreateDto.getSalaryTo());
        job.setDegreeLevel(jobCreateDto.getDegreeLevel());
        job.setWorkTimeType(jobCreateDto.getWorkTimeType());
        job.setLocation(jobCreateDto.getLocation());
        job.setWorkLocationType(jobCreateDto.getWorkLocationType());
        job.setWorkTimeForm(jobCreateDto.getWorkTimeForm());
        job.setWorkTimeTo(jobCreateDto.getWorkTimeTo());
        final Job save = jobRepository.save(job);
        LOGGER.info(save.toString());
    }
}
