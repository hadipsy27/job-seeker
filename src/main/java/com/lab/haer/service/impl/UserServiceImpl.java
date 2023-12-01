package com.lab.haer.service.impl;

import com.lab.haer.dto.UserDto;
import com.lab.haer.entity.Role;
import com.lab.haer.entity.User;
import com.lab.haer.repository.RoleRepository;
import com.lab.haer.repository.UserRepository;
import com.lab.haer.service.UserService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(UserServiceImpl.class);

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Override
    public User createAndUpdateUser(UserDto userDto) {

        final User user = new User();
        user.setFullName(userDto.getFullName());
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setCompany(userDto.getCompany());

        final Role roleUser = roleRepository.findRoleByName("USER");
        List<Role> roles = List.of(roleUser);
        user.setRoles(roles);

        LocalDateTime dateTime = LocalDateTime.now();
        user.setCreatedAt(dateTime);
        user.setUpdatedAt(dateTime);

        userRepository.save(user);
        LOGGER.info(user.toString());
        return user;
    }
}
