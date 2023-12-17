package com.lab.haer.service.impl;

import com.lab.haer.entity.Role;
import com.lab.haer.repository.RoleRepository;
import com.lab.haer.service.RoleService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final static Logger LOGGER = LoggerFactory.getLogger(RoleService.class);

    private RoleRepository roleRepository;

    public List<Role> findRoleByIdList(List<String> userId) {
        return roleRepository.findRoleByIdIsIn(userId);

    }

    @Override
    public List<Role> createRole() {

        Role roleAdmin = new Role();
        roleAdmin.setId("1");
        roleAdmin.setName("ADMIN");
        Role saveRoleAdmin = roleRepository.save(roleAdmin);
        LOGGER.info(saveRoleAdmin.toString());

        Role roleHR = new Role();
        roleHR.setId("2");
        roleHR.setName("HR");
        Role saveRoleHR = roleRepository.save(roleHR);
        LOGGER.info(saveRoleHR.toString());

        Role roleUser = new Role();
        roleUser.setId("3");
        roleUser.setName("USER");
        Role saveRoleUser = roleRepository.save(roleUser);
        LOGGER.info(saveRoleUser.toString());

        List<Role> allRole = roleRepository.findAll();
        LOGGER.info(allRole.toString());

        return allRole;
    }

}
