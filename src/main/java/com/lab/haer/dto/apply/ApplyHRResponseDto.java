package com.lab.haer.dto.apply;

import com.lab.haer.enums.Status;
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
public class ApplyHRResponseDto {

    private String jobId;
    private String jobTitle;
    private String jobDescription;
    private String applyId;
    private boolean applied;
    private LocalDate interviewDate;
    private LocalTime interviewTime;
    private String interviewLink;
    private String status;
    private String userId;
    private String username;
    private String fullName;

    public ApplyHRResponseDto(String applyId, Boolean applied, LocalDate interviewDate, String interviewLink, LocalTime interviewTime, Status status, String jobId, String jobTitle, String jobDescription, String userId, String username, String fullName) {
        // Constructor implementation
        this.applyId = applyId;
        this.applied = applied;
        this.interviewDate = interviewDate;
        this.interviewLink = interviewLink;
        this.interviewTime = interviewTime;
        this.status = status.toString();
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.userId = userId;
        this.username = username;
        this.fullName = fullName;

    }

}
