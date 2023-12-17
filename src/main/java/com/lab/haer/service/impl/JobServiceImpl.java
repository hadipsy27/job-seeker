package com.lab.haer.service.impl;

import com.lab.haer.config.ModelMapperConfig;
import com.lab.haer.dto.JobAllResponseDto;
import com.lab.haer.dto.JobCreateDto;
import com.lab.haer.dto.JobUpdateDto;
import com.lab.haer.dto.apply.ApplyHRResponseDto;
import com.lab.haer.entity.Category;
import com.lab.haer.entity.Job;
import com.lab.haer.entity.Role;
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
import java.util.stream.Collectors;

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

        final List<Category> categories = categoryService.findCategoriesByCodes(jobCreateDto.getCategoryCodes());
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
        if (!userById.getRoles().stream().anyMatch(role -> role.getName().equals("HR"))) {
            throw new RuntimeException("You can't create a Job because you not Human Resource!!");
        }
        job.setUser(userById);

        final Job save = jobRepository.save(job);
        LOGGER.info(save.toString());

        final JobCreateDto result = modelMapper.modelMapper().map(save, JobCreateDto.class);
        result.setCategoryCodes(categories.stream().map(Category::getCode).toList());
        result.setUserId(userById.getId());
        LOGGER.info(result.toString());

        return result;

    }

    @SneakyThrows
    @Override
    public JobUpdateDto updateJob(String id, JobUpdateDto jobUpdateDto) {

        final Job jobById = jobRepository.findJobById(String.valueOf(id));
        if (jobById == null) throw new RuntimeException("Job Not Found");

        jobById.setTitle(jobUpdateDto.getTitle());

        final List<Category> categories = categoryService.findCategoriesByCodes(jobUpdateDto.getCategoryCodes());
        LOGGER.info(categories.toString());
        jobById.setCategories(categories);

        jobById.setSortDescription(jobUpdateDto.getSortDescription());
        jobById.setDescription(jobUpdateDto.getDescription());
        jobById.setSalaryForm(jobUpdateDto.getSalaryForm());
        jobById.setSalaryTo(jobUpdateDto.getSalaryTo());
        jobById.setDegreeLevel(jobUpdateDto.getDegreeLevel());
        jobById.setWorkTimeType(jobUpdateDto.getWorkTimeType());
        jobById.setLocation(jobUpdateDto.getLocation());
        jobById.setWorkLocationType(jobUpdateDto.getWorkLocationType());
        jobById.setWorkTimeForm(jobUpdateDto.getWorkTimeForm());
        jobById.setWorkTimeTo(jobUpdateDto.getWorkTimeTo());

        final Job save = jobRepository.save(jobById);
        LOGGER.info(save.toString());

        final JobUpdateDto result = modelMapper.modelMapper().map(save, JobUpdateDto.class);
        result.setCategoryCodes(categories.stream().map(Category::getCode).toList());
        LOGGER.info(result.toString());

        return result;
    }

    @Override
    public List<JobAllResponseDto> findAllJob() {
        final List<Job> jobList = jobRepository.findAll();
        if (jobList.isEmpty()) throw new RuntimeException("Job Not Found");
        LOGGER.info(jobList.toString());

        return jobList.stream().map(job -> {
            final JobAllResponseDto response = modelMapper.modelMapper().map(job, JobAllResponseDto.class);
            return response;
        }).collect(Collectors.toList());

    }

    @Override
    public JobAllResponseDto findJobById(String id) {
        final Job jobById = jobRepository.findJobById(id);
        if (jobById == null) throw new RuntimeException("Job Not Found");

        final JobAllResponseDto response = modelMapper.modelMapper().map(jobById, JobAllResponseDto.class);
        return response;
    }

    @Override
    public List<JobAllResponseDto> getJobByUserId(String userId) {
        final List<Job> jobList = jobRepository.findJobByUserId(userId);
        if (jobList.isEmpty()) throw new RuntimeException("Job Not Found");
        LOGGER.info(jobList.toString());

        return jobList.stream().map(job -> {
            final JobAllResponseDto response = modelMapper.modelMapper().map(job, JobAllResponseDto.class);
            return response;
        }).collect(Collectors.toList());
    }

    @Override
    public List<ApplyHRResponseDto> getAppliedJobByHRUserId(String userId) {
        List<Object[]> result = jobRepository.findJobApplied(userId);

        return result.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private ApplyHRResponseDto mapToDto(Object[] result) {
        ApplyHRResponseDto dto = new ApplyHRResponseDto();

        dto.setJobId((String) result[0]);
        dto.setJobTitle((String) result[1]);
        dto.setJobDescription((String) result[2]);
        dto.setApplyId((String) result[3]);
        dto.setApplied((boolean) result[4]);
        dto.setStatus((String) result[5]);
        dto.setUserId((String) result[6]);
        dto.setUsername((String) result[7]);
        dto.setFullName((String) result[8]);

        return dto;
    }

}
