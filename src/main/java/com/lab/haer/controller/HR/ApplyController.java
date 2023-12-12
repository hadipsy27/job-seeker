package com.lab.haer.controller.HR;

import com.lab.haer.dto.apply.*;
import com.lab.haer.service.ApplyService;
import com.lab.haer.util.ResponseHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class ApplyController {

    private ApplyService applyService;

    @PostMapping("/hr/apply")
    public ResponseEntity<Object> userApplyJob(@RequestBody ApplyUserCreateDto applyUserCreateDto){
        try {
            final ApplyUserCreateDto response = applyService.createUserApplyJob(applyUserCreateDto);
            return ResponseHandler.generateResponse("Success to apply!!", HttpStatus.OK, response);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
        }
    }

    @GetMapping("/hr/apply")
    public ResponseEntity<Object> getAllApply() {
        try {
            final List<ApplyHRResponseDto> response = applyService.findAllApplyJob();
            return ResponseHandler.generateResponse("Success to get all Apply!!", HttpStatus.OK, response);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
        }
    }

    @GetMapping("/user/apply/{applyId}")
    public ResponseEntity<Object> getDetailUserJobApply(@PathVariable("applyId") String applyId){
        try{
            final ApplyHRDetailResponseDto jobUserApplied = applyService.findJobUserApplied(applyId);
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, jobUserApplied);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
        }
    }

    @PutMapping("/hr/apply-job-user/{applyId}")
    public ResponseEntity<Object> HRAppliedJobUser(@PathVariable("applyId") String applyId, @RequestBody ReplyUserApplyJobDTO replyUserApplyJobDTO){
        try{
            final ApplyJobUserResponseDto response = applyService.HRAppliedJobUser(applyId, replyUserApplyJobDTO);
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, response);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
        }
    }
}
