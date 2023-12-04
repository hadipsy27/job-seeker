package com.lab.haer.repository;

import com.lab.haer.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {

    public List<Role> findRoleByIdIsIn(List<String> id);

}
