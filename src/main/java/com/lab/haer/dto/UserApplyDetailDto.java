package com.lab.haer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserApplyDetailDto {

    private String applyId;
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

}
