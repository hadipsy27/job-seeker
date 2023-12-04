package com.lab.haer.repository;

import com.lab.haer.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, String> {

    List<Category> findByCodeIn(List<String> code);

}
