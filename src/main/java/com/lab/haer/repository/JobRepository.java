package com.lab.haer.repository;

import com.lab.haer.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, String> {

    public Job findJobById(String id);

    public List<Job> findJobByUserId(String userId);

//    @Query(value = "select j.*, a.*, u.* from job j \n" +
//            "inner join apply a on j.id = a.job_id\n" +
//            "inner join \"user\" u on u.id = a.user_id \n" +
//            "where j.user_id = ?1 " +
//            "and a.applied = true", nativeQuery = true)
//        // 'ea3eed55-827f-4286-bd6a-46327b7bdacf' -> User Hadi
//    List<ApplyHRResponseDto> findJobApplied(String userId);

//    @Query(value = "SELECT j.*, a.*, u.* FROM job j " +
//            "INNER JOIN apply a ON j.id = a.job_id " +
//            "INNER JOIN user u ON u.id = a.user_id " +
//            "WHERE j.user_id = :userId AND a.applied = true", nativeQuery = true)
//    List<Object[]> findJobApplied(@Param("userId") String userId);

//    @Query(value = "SELECT j.id AS job_id, j.title AS job_title, j.description AS job_description, " +
//            "a.id AS apply_id, a.applied AS applied, " +
//            "u.id AS user_id, u.username AS username, u.full_name AS full_name " +
//            "FROM job j " +
//            "INNER JOIN apply a ON j.id = a.job_id " +
//            "INNER JOIN user u ON u.id = a.user_id " +
//            "WHERE j.user_id = :userId AND a.applied = true", nativeQuery = true)
//    List<Object[]> findJobApplied(@Param("userId") String userId);


    @Query(value = "SELECT\n" +
            "    j.id AS job_id,\n" +
            "    j.title AS job_title,\n" +
            "    j.description AS job_description,\n" +
            "    a.id AS apply_id,\n" +
            "    a.applied AS applied,\n" +
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
