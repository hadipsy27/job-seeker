package com.lab.haer.controller;

import com.lab.haer.entity.Role;
import com.lab.haer.service.RoleService;
import com.lab.haer.util.ResponseHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@AllArgsConstructor
public class RoleController {

    private RoleService roleService;

    @PostMapping("/create/role")
    public ResponseEntity<Object> createRole(){
        try {
            List<Role> roles = roleService.createRole();
            return ResponseHandler.generateResponse("Success generate Roles", HttpStatus.CREATED, roles);
        } catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }


}
