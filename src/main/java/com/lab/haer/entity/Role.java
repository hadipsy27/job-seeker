package com.lab.haer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "role")
public class Role {

    @Id
    private String id = UUID.randomUUID().toString();

    @Column(name = "name", nullable = false)
    private String name;
}
