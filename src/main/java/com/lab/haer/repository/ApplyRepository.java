package com.lab.haer.repository;

import com.lab.haer.entity.Apply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplyRepository extends JpaRepository<Apply, String> {

    List<Apply> findAll();
}
