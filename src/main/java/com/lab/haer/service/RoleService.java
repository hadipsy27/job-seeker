package com.lab.haer.service;

import com.lab.haer.entity.Role;

import java.util.List;

public interface RoleService {

    public List<Role> findRoleByIdList(List<String> roleId);
}
