package com.lab.haer.service.impl;

import com.lab.haer.entity.Role;
import com.lab.haer.repository.RoleRepository;
import com.lab.haer.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    public List<Role> findRoleByIdList(List<String> userId) {
        return roleRepository.findRoleByIdIsIn(userId);

    }
}
