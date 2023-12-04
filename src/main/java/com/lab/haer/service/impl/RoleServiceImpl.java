package com.lab.haer.service.impl;

import com.lab.haer.entity.Role;
import com.lab.haer.repository.RoleRepository;
import com.lab.haer.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    public Role findRoleById(String userId) {
        return roleRepository.findRolesById(userId);

    }
}
