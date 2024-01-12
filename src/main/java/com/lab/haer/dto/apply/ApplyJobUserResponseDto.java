package com.lab.haer.dto.apply;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplyJobUserResponseDto {

    private String id;
    private boolean applied;
    private String status;
    private LocalDate interviewDate;
    private LocalTime interviewTime;
    private String interviewLink;

    private String jobId;
    private String title;
    private String description;
    private String sortDescription;
    private String uploadDate;
    private String salaryForm;
    private String salaryTo;
    private String degreeLevel;
    private String workTimeType;
    private String location;
    private String workLocationType;
    private LocalTime workTimeForm;
    private LocalTime workTimeTo;

    private String userId;
    private String username;
    private String fullName;
    private String email;
}
