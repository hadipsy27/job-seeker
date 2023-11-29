package com.lab.haer.job.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobDto {
    private String title;
    private String category;
    private String description;
    private String sortDescription;
    private String uploadDate;
    private String user;
    private String salaryForm;
    private String salaryTo;
    private String degreeLevel;
    private String workTimeType;
    private String location;
    private String workLocationType;
    private String workTimeForm;
    private String workTimeTo;
}
