package com.lab.haer.repository;

import com.lab.haer.entity.Apply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ApplyRepository extends JpaRepository<Apply, String> {

    List<Apply> findAll();

    @Query(value = "SELECT " +
            "a.id AS id, " +
            "a.applied AS applied, " +
            "a.interview_date AS interviewDate, " +
            "a.interview_time AS interviewTime, " +
            "a.interview_link AS interviewLink, " +
            "j.id AS jobId, " +
            "j.title AS title, " +
            "j.description AS description, " +
            "j.sort_description AS sortDescription, " +
            "j.upload_date AS uploadDate, " +
            "j.salary_form AS salaryForm, " +
            "j.salary_to AS salaryTo, " +
            "j.degree_level AS degreeLevel, " +
            "j.work_time_type AS workTimeType, " +
            "j.location AS location, " +
            "j.work_location_type AS workLocationType, " +
            "j.work_time_form AS workTimeForm, " +
            "j.work_time_to AS workTimeTo, " +
            "u.id AS userId, " +
            "u.username AS username, " +
            "u.full_name AS fullName, " +
            "u.email AS email " +
            "FROM apply a " +
            "INNER JOIN job j ON j.id = a.job_id " +
            "INNER JOIN \"user\" u ON u.id = a.user_id " +
            "WHERE a.id = :applyId", nativeQuery = true)
    Object findJobUserApplied(@Param("applyId") String applyId);

}
