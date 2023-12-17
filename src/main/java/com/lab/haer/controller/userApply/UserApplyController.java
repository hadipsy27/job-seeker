package com.lab.haer.controller.userApply;

import com.lab.haer.dto.UserApplyDto;
import com.lab.haer.service.UserAcceptedService;
import com.lab.haer.util.ResponseHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("api/v1/")
@AllArgsConstructor
public class UserApplyController {

    private UserAcceptedService userAcceptedService;

    @GetMapping("/job/apply/user/{userId}")
    public ResponseEntity<Object> getAllUserApplyByUserId(@PathVariable("userId") String userId) {
        try {
            final List<UserApplyDto> response = userAcceptedService.findAllJobUserById(userId);
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
