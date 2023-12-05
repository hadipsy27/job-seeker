package com.lab.haer.service.impl;

import com.lab.haer.config.ModelMapperConfig;
import com.lab.haer.dto.UserCreateDto;
import com.lab.haer.dto.UserResponseDto;
import com.lab.haer.entity.Role;
import com.lab.haer.entity.User;
import com.lab.haer.repository.UserRepository;
import com.lab.haer.service.RoleService;
import com.lab.haer.service.UserService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final static String ROLE_USER = "1";
    private final static String ROLE_HR = "2";
    private final static String ROLE_ADMIN = "3";
    private final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(UserServiceImpl.class);
    private ModelMapperConfig modelMapperConfig;
    private UserRepository userRepository;
    private RoleService roleService;

    @Override
    public UserResponseDto createAndUpdateUser(UserCreateDto userCreateDto) {

        final User user = new User();
        user.setFullName(userCreateDto.getFullName());
        user.setEmail(userCreateDto.getEmail());
        user.setUsername(userCreateDto.getUsername());
        user.setPassword(userCreateDto.getPassword());
        user.setCompany(userCreateDto.getCompany());

        // Role can set by static attribute list [ROLE_USER, ROLE_HR, ROLE_ADMIN]
        final List<Role> roleById = roleService.findRoleByIdList(List.of(ROLE_USER));
        LOGGER.info(roleById.toString());
        user.setRoles(roleById);

        LocalDateTime dateTime = LocalDateTime.now();
        user.setCreatedAt(dateTime);
        user.setUpdatedAt(dateTime);

        final User save = userRepository.save(user);
        LOGGER.info(user.toString());

        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto = modelMapperConfig.modelMapper().map(save, userResponseDto.getClass());
        userResponseDto.setRoles(roleById.stream().map(Role::getName).toList());

        LOGGER.info(userResponseDto.toString());
        return userResponseDto;
    }

    public User findUserById(String id){
        final User userById = userRepository.findUserById(id);
        return userById;
    }
}
