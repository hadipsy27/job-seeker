package com.lab.haer.repository;

import com.lab.haer.dto.apply.ApplyHRDetailResponseDto;
import com.lab.haer.dto.apply.ApplyHRResponseDto;
import com.lab.haer.entity.Apply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ApplyRepository extends JpaRepository<Apply, String> {

    @Query("SELECT new com.lab.haer.dto.apply.ApplyHRResponseDto(" +
            "a.id, " +
            "a.applied, " +
            "a.interviewDate, " +
            "a.interviewLink, " +
            "a.interviewTime, " +
            "a.status, " +
            "j.id, " +
            "j.title, " +
            "j.description, " +
            "u.id, " +
            "u.username, " +
            "u.fullName) " +
            "FROM Apply a " +
            "JOIN a.job j " +
            "JOIN a.user u")
    List<ApplyHRResponseDto> findAllApply();

    @Query("SELECT new com.lab.haer.dto.apply.ApplyHRDetailResponseDto(" +
            "a.id," +
            "a.applied, " +
            "a.status, " +
            "a.interviewDate, " +
            "a.interviewTime, " +
            "a.interviewLink, " +
            "a.jobSeekerAccepted, " +
            "a.jobSeekerReply, " +
            "j.id, " +
            "j.title, " +
            "j.description, " +
            "j.sortDescription, " +
            "j.uploadDate, " +
            "j.salaryForm, " +
            "j.salaryTo, " +
            "j.degreeLevel, " +
            "j.workTimeType, " +
            "j.location, " +
            "j.workLocationType, " +
            "j.workTimeForm, " +
            "j.workTimeTo, " +
            "u.id, " +
            "u.username, " +
            "u.fullName, " +
            "u.email) " +
            "FROM Apply a " +
            "JOIN a.job j " +
            "JOIN a.user u " +
            "WHERE a.id = :applyId")
    ApplyHRDetailResponseDto findJobUserApplied(@Param("applyId") String applyId);

}
