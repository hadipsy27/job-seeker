package com.lab.haer.service.impl;

import com.lab.haer.config.ModelMapperConfig;
import com.lab.haer.dto.JobCreateDto;
import com.lab.haer.entity.Category;
import com.lab.haer.entity.Job;
import com.lab.haer.entity.User;
import com.lab.haer.repository.JobRepository;
import com.lab.haer.service.CategoryService;
import com.lab.haer.service.JobService;
import com.lab.haer.service.UserService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class JobServiceImpl implements JobService {

    private final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(JobServiceImpl.class);
    private ModelMapperConfig modelMapper;

    private JobRepository jobRepository;
    private CategoryService categoryService;
    private UserService userService;

    @SneakyThrows
    @Override
    public JobCreateDto createJob(JobCreateDto jobCreateDto) {

        Job job = new Job();
        job.setTitle(jobCreateDto.getTitle());

        final List<Category> categories = categoryService.findCategories(jobCreateDto.getCategoryCodes());
        LOGGER.info(categories.toString());
        job.setCategories(categories);

        job.setSortDescription(jobCreateDto.getSortDescription());
        job.setDescription(jobCreateDto.getDescription());

        final LocalDateTime dateTime = LocalDateTime.now();
        job.setUploadDate(dateTime.toString());

        job.setSalaryForm(jobCreateDto.getSalaryForm());
        job.setSalaryTo(jobCreateDto.getSalaryTo());
        job.setDegreeLevel(jobCreateDto.getDegreeLevel());
        job.setWorkTimeType(jobCreateDto.getWorkTimeType());
        job.setLocation(jobCreateDto.getLocation());
        job.setWorkLocationType(jobCreateDto.getWorkLocationType());
        job.setWorkTimeForm(jobCreateDto.getWorkTimeForm());
        job.setWorkTimeTo(jobCreateDto.getWorkTimeTo());
        job.setCreatedAt(dateTime);
        job.setUpdatedAt(dateTime);

        final User userById = userService.findUserById(jobCreateDto.getUserId());
        LOGGER.info(userById.toString());
        job.setUser(userById);

        final Job save = jobRepository.save(job);
        LOGGER.info(save.toString());

        final JobCreateDto result = modelMapper.modelMapper().map(save, JobCreateDto.class);
        result.setCategoryCodes(categories.stream().map(Category::getCode).toList());
        result.setUserId(userById.getId());
        LOGGER.info(result.toString());

        return result;

    }
}
