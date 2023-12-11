package com.lab.haer.controller.HR;

import com.lab.haer.dto.apply.ApplyUserCreateDto;
import com.lab.haer.service.ApplyService;
import com.lab.haer.util.ResponseHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hr")
@AllArgsConstructor
public class ApplyController {

    private ApplyService applyService;

    @PostMapping("/apply")
    public ResponseEntity<Object> userApplyJob(@RequestBody ApplyUserCreateDto applyUserCreateDto){
        try {
            final ApplyUserCreateDto response = applyService.createUserApplyJob(applyUserCreateDto);
            return ResponseHandler.generateResponse("Success to apply!!", HttpStatus.OK, response);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
        }
    }

    @GetMapping("/apply")
    public ResponseEntity<Object> getAllApply() {
        try {
            final List<ApplyUserCreateDto> response = applyService.findAllApplyJob();
            return ResponseHandler.generateResponse("Success to get all Apply!!", HttpStatus.OK, response);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
        }
    }
}
