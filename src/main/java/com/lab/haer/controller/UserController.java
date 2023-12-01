package com.lab.haer.controller;

import com.lab.haer.dto.UserDto;
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

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody UserDto userDto) {
        try{
            User response =  userService.createAndUpdateUser(userDto);
            return ResponseHandler.generateResponse("Successfully added User!!", HttpStatus.CREATED, response);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
        }

    }

}
