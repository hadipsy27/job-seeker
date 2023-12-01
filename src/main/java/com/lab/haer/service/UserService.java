package com.lab.haer.service;

import com.lab.haer.dto.UserDto;
import com.lab.haer.entity.User;

public interface UserService {

    User createAndUpdateUser(UserDto userDto);
}
