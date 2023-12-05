package com.lab.haer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobCreateDto {
    private String title;
    private List<String> categoryCodes;
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
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
