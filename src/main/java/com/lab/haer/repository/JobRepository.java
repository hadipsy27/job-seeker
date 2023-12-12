package com.lab.haer.repository;

import com.lab.haer.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, String> {

    public Job findJobById(String id);

    public List<Job> findJobByUserId(String userId);

    @Query(value = "SELECT\n" +
            "    j.id AS job_id,\n" +
            "    j.title AS job_title,\n" +
            "    j.description AS job_description,\n" +
            "    a.id AS apply_id,\n" +
            "    a.applied AS applied,\n" +
            "    a.status AS status,\n" +
            "    u.id AS user_id,\n" +
            "    u.username AS username,\n" +
            "    u.full_name AS full_name\n" +
            "FROM\n" +
            "    job j\n" +
            "INNER JOIN\n" +
            "    apply a ON j.id = a.job_id\n" +
            "INNER JOIN\n" +
            "    \"user\" u ON u.id = a.user_id\n" +
            "WHERE\n" +
            "    j.user_id = :userId\n" +
            "AND a.applied = true;", nativeQuery = true)
    List<Object[]> findJobApplied(@Param("userId") String userId);


}
