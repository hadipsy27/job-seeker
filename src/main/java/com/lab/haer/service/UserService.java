package com.lab.haer.service;

import com.lab.haer.dto.UserCreateDto;
import com.lab.haer.dto.UserResponseDto;
import com.lab.haer.entity.User;

public interface UserService {

    UserResponseDto createAndUpdateUser(UserCreateDto userCreateDto);

    User findUserById(String id);
}
