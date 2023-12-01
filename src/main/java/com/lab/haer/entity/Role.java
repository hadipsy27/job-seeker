package com.lab.haer.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "role")
public class Role {

    @Id
    private String id = UUID.randomUUID().toString();

    @Column(name = "name", nullable = false)
    private String name;

//    @ManyToMany(mappedBy = "role")
//    private List<User> user;
}
