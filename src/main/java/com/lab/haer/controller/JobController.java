package com.lab.haer.controller;

import com.lab.haer.dto.JobCreateDto;
import com.lab.haer.service.JobService;
import com.lab.haer.util.ResponseHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Object> saveJob(@RequestBody JobCreateDto jobCreateDto) {
        try {
            final JobCreateDto result = jobService.createJob(jobCreateDto);
            return ResponseHandler.generateResponse("Success", HttpStatus.CREATED, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
        }
    }

}
