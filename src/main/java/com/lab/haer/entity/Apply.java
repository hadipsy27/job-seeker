package com.lab.haer.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lab.haer.enums.JobSeekerAccepted;
import com.lab.haer.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "apply")
public class Apply {

    @Id
    private String id = UUID.randomUUID().toString();

    @Column(nullable = false)
    private boolean applied;

    @Enumerated(EnumType.STRING)
    @Column(name = "status",nullable = false)
    private Status status = Status.WAITING;

    @Column(name = "interview_date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate interviewDate;
    @Column(name = "interview_time")
    private LocalTime interviewTime;
    @Column(name = "interview_link")
    private String interviewLink;

    @Enumerated(EnumType.STRING)
    @Column(name = "job_seeker_accepted", nullable = false)
    private JobSeekerAccepted jobSeekerAccepted = JobSeekerAccepted.WAITING;

    @Column(name = "job_seeker_reply", columnDefinition = "TEXT")
    private String jobSeekerReply;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
