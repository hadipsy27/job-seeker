package com.lab.haer.repository;

import com.lab.haer.entity.Apply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserApplyRepository extends JpaRepository<Apply, String> {


    @Query(value =
            "SELECT " +
                    "a.id AS applyId, " +
                    "a.status, " +
                    "a.interview_date AS interviewDate, " +
                    "a.interview_time AS interviewTime, " +
                    "j.id AS jobId, " +
                    "j.title, " +
                    "j.sort_description AS sortDescription, " +
                    "j.upload_date AS uploadDate, " +
                    "j.location " +
                    "FROM apply a " +
                    "INNER JOIN job j ON j.id = a.job_id " +
                    "WHERE a.user_id = :userId ",
            nativeQuery = true)
    List<Object[]> findUserApplyByUserId(@Param("userId") String userId);


}
