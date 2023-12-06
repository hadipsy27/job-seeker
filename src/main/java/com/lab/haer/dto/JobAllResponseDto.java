package com.lab.haer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAllResponseDto {
    private String id;
    private String title;
    private String uploadDate;
    private String salaryForm;
    private String salaryTo;
    private String location;
    private String workLocationType;
    private String sortDescription;
}
