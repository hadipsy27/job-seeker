package com.lab.haer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateDto {
    private String username;
    private String fullName;
    private String email;
    private String password;
    private String company;
}
