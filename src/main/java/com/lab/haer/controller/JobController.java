package com.lab.haer.controller;

import com.lab.haer.dto.JobCreateDto;
import com.lab.haer.service.JobService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class JobController {

    private JobService jobService;

    @PostMapping("/jobs")
    public ResponseEntity<JobCreateDto> saveJob(@RequestBody JobCreateDto jobCreateDto) {
//        JobService.createJob(jobCreateDto);
        return null;
    }

}
