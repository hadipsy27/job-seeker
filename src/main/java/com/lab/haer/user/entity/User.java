package com.lab.haer.user.entity;

import com.lab.haer.user.enumeration.UserEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String id = UUID.randomUUID().toString();
    private String email;
    private String password;
    private String company;
    private String username;
    private String fullName;
    private Enum role;
    private Date createdAt;
    private Date updatedAt;
}
