package com.lab.haer.service;

import com.lab.haer.dto.UserCreateDto;
import com.lab.haer.dto.UserResponseDto;
import com.lab.haer.entity.User;

import java.util.List;

public interface UserService {

    UserResponseDto createAndUpdateUser(UserCreateDto userCreateDto, List<String> roleId);

    User findUserById(String id);
}
