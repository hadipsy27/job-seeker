package com.lab.haer.dto;

import com.lab.haer.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAllResponseDto {
    private String id;
    private String title;
    private String companyUser;
    private String fullNameUser;
    private String uploadDate;
    private String salaryForm;
    private String salaryTo;
    private String location;
    private String workLocationType;
    private String sortDescription;
}
