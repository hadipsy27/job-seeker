package com.lab.haer.repository;

import com.lab.haer.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, String> {

    public Job findJobById(String id);

    public List<Job> findJobByUserId(String userId);
}
