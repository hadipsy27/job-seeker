package com.lab.haer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobCreateDto {
    private String title;
    private List<String> categoryId;
    private String description;
    private String sortDescription;
//    private String uploadDate;
    private List<String> userid;
    private String salaryForm;
    private String salaryTo;
    private String degreeLevel;
    private String workTimeType;
    private String location;
    private String workLocationType;
    private LocalTime workTimeForm;
    private LocalTime workTimeTo;

}
