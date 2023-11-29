package com.lab.haer.job.entity;

import com.lab.haer.user.entity.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Job {

    @Id
    private String id = UUID.randomUUID().toString();
    private String title;
    private String category;
    @Lob
    private String description;
    private String sortDescription;
    private String uploadDate;
//    private String user;
    private String salaryForm;
    private String salaryTo;
    private String degreeLevel;
    private String workTimeType;
    private String location;
    private String workLocationType;
    private String workTimeForm;
    private String workTimeTo;
    private Date createdAt;
    private Date updatedAt;

}
