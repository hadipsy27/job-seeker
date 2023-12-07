package com.lab.haer.controller;

import com.lab.haer.dto.JobAllResponseDto;
import com.lab.haer.dto.JobCreateDto;
import com.lab.haer.dto.JobUpdateDto;
import com.lab.haer.service.JobService;
import com.lab.haer.util.ResponseHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/jobs/{id}")
    public ResponseEntity<Object> updateJob(@PathVariable("id") String id, @RequestBody JobUpdateDto jobUpdateDto) {
        try {
            final JobUpdateDto result = jobService.updateJob(id, jobUpdateDto);
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
        }
    }

    @GetMapping("/jobs")
    private ResponseEntity<Object> findAllJob() {
        try {
            final List<JobAllResponseDto> result = jobService.findAllJob();
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
        }
    }

    @GetMapping("/jobs/{id}")
    private ResponseEntity<Object> findJobById(@PathVariable("id") String id) {
        try {
            final JobAllResponseDto result = jobService.findJobById(id);
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
        }
    }

    @GetMapping("/jobs/user/{userId}")
    public ResponseEntity<Object> findJobByUserId(@PathVariable("userId") String userId) {
        try {
            final List<JobAllResponseDto> result = jobService.getJobByUserId(userId);
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
        }
    }

}
