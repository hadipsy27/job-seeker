package com.lab.haer.entity;

import com.lab.haer.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private LocalDate interviewDate;
    @Column(name = "interview_time")
    private LocalTime interviewTime;
    @Column(name = "interview_link")
    private String interviewLink;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
