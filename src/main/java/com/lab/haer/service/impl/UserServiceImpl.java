package com.lab.haer.service.impl;

import com.lab.haer.dto.UserDto;
import com.lab.haer.entity.Category;
import com.lab.haer.entity.User;
import com.lab.haer.repository.CategoryRepository;
import com.lab.haer.repository.UserRepository;
import com.lab.haer.service.UserService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;
    @Override
    public void createAndUpdateUser(UserDto userDto) {
        final User user = new User();
        user.setFullName(userDto.getFullName());
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setCompany(userDto.getCompany());
        userRepository.save(user);
        LOGGER.info(user.toString());
    }
}
