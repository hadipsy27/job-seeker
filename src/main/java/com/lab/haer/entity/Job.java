package com.lab.haer.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job")
public class Job {

    @Id
    private String id = UUID.randomUUID().toString();
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    @Column(name = "sort_description")
    private String sortDescription;
    @CreatedDate
    @Column(name = "upload_date")
    private String uploadDate;
    @Column(name = "salary_form", nullable = false, updatable = false)
    private String salaryForm;
    @Column(name = "salary_to")
    private String salaryTo;
    @Column(name = "degree_level")
    private String degreeLevel;
    @Column(name = "work_time_type")
    private String workTimeType;
    @Column(name = "location")
    private String location;
    @Column(name = "work_location_type")
    private String workLocationType;

    @JsonFormat(pattern = "hh:mm")
    @Column(name = "work_time_form")
    private LocalTime workTimeForm;

    @JsonFormat(pattern = "hh:mm")
    @Column(name = "work_time_to")
    private LocalTime workTimeTo;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToMany
    @JoinTable(name = "job_category", joinColumns = {
    @JoinColumn(name="job_id", referencedColumnName = "id")},
    inverseJoinColumns = {
            @JoinColumn(name="category_code", referencedColumnName = "code")
    })
    private List<Category> categories;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
