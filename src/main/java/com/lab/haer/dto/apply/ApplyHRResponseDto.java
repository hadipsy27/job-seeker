package com.lab.haer.dto.apply;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplyHRResponseDto {

    private String jobId;
    private String jobTitle;
    private String jobDescription;
    private String applyId;
    private boolean applied;
    private String status;
    private String userId;
    private String username;
    private String fullName;

}
