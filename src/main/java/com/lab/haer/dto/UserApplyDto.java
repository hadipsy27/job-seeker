package com.lab.haer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserApplyDto {

    private String applyId;
    private String status;
    private LocalDate interviewDate;
    private LocalTime interviewTime;

    private String jobId;
    private String title;
    private String sortDescription;
    private String uploadDate;
    private String location;

}
