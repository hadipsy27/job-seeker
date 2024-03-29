package com.lab.haer.controller;

import com.lab.haer.dto.UserCreateDto;
import com.lab.haer.dto.UserResponseDto;
import com.lab.haer.entity.User;
import com.lab.haer.service.UserService;
import com.lab.haer.util.ResponseHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<Object> createUserRoleUser(@RequestBody UserCreateDto userCreateDto) {
        try{
            userCreateDto.setCompany(null);
            UserResponseDto response =  userService.createAndUpdateUser(userCreateDto, Collections.singletonList("3"));
            return ResponseHandler.generateResponse("Successfully added User!!", HttpStatus.CREATED, response);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
        }

    }

    @PostMapping("/hr")
    public ResponseEntity<Object> createUserRoleHR(@RequestBody UserCreateDto userCreateDto) {
        try{
            UserResponseDto response =  userService.createAndUpdateUser(userCreateDto, List.of("2","3"));
            return ResponseHandler.generateResponse("Successfully added User!!", HttpStatus.CREATED, response);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
        }

    }

}
