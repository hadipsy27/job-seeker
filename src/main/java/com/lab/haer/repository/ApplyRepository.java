package com.lab.haer.repository;

import com.lab.haer.entity.Apply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ApplyRepository extends JpaRepository<Apply, String> {

    List<Apply> findAll();

    @Query(value = "select a.*, j.*, u.* from apply a \n" +
            "inner join job j on j.id = a.job_id\n" +
            "inner join \"user\" u on u.id = a.user_id \n" +
            "where a.id = :applyId", nativeQuery = true)
    List<Object[]> findJobUserApplied(@Param("applyId") String applyId);
}
