package com.lab.haer.repository;

import com.lab.haer.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    public Role findRoleByName(String name);

}
