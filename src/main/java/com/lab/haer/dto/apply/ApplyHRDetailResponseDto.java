package com.lab.haer.dto.apply;

import com.lab.haer.enums.JobSeekerAccepted;
import com.lab.haer.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.management.ConstructorParameters;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplyHRDetailResponseDto {

    private String applyId;
    private boolean applied;
    private String status;
    private LocalDate interviewDate;
    private LocalTime interviewTime;
    private String interviewLink;
    private String jobSeekerAccepted;
    private String jobSeekerReply;
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


    public ApplyHRDetailResponseDto(
            String applyId,
            boolean applied,
            Status status,
            LocalDate interviewDate,
            LocalTime interviewTime,
            String interviewLink,
            JobSeekerAccepted jobSeekerAccepted,
            String jobSeekerReply,
            String jobId,
            String title,
            String description,
            String sortDescription,
            String uploadDate,
            String salaryForm,
            String salaryTo,
            String degreeLevel,
            String workTimeType,
            String location,
            String workLocationType,
            LocalTime workTimeForm,
            LocalTime workTimeTo,
            String userId,
            String username,
            String fullName,
            String email
    ) {
        this.applyId = applyId;
        this.applied = applied;
        this.status = status.toString();
        this.interviewDate = interviewDate;
        this.interviewTime = interviewTime;
        this.interviewLink = interviewLink;
        this.jobSeekerAccepted = jobSeekerAccepted != null ? jobSeekerAccepted.name() : null;
        this.jobSeekerReply = jobSeekerReply;
        this.jobId = jobId;
        this.title = title;
        this.description = description;
        this.sortDescription = sortDescription;
        this.uploadDate = uploadDate;
        this.salaryForm = salaryForm;
        this.salaryTo = salaryTo;
        this.degreeLevel = degreeLevel;
        this.workTimeType = workTimeType;
        this.location = location;
        this.workLocationType = workLocationType;
        this.workTimeForm = workTimeForm;
        this.workTimeTo = workTimeTo;
        this.userId = userId;
        this.username = username;
        this.fullName = fullName;
        this.email = email;
    }
}
