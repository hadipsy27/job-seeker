package com.lab.haer.entity;

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
@Table(name = "`job`")
public class Job {

    @Id
    private String id = UUID.randomUUID().toString();
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = true, columnDefinition = "TEXT")
    private String description;
    @Lob
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
    @Column(name = "work_time_form")
    private LocalTime workTimeForm;
    @Column(name = "work_time_to")
    private LocalTime workTimeTo;
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL)
    private List<Category> categories;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
