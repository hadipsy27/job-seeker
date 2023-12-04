package com.lab.haer.service;

import com.lab.haer.dto.UserCreateDto;
import com.lab.haer.dto.UserResponseDto;

public interface UserService {

    UserResponseDto createAndUpdateUser(UserCreateDto userCreateDto);
}
