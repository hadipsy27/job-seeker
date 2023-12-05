package com.lab.haer.repository;

import com.lab.haer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    User findUserById(String id);
}
