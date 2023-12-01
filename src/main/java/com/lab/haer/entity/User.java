package com.lab.haer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "`user`")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String id = UUID.randomUUID().toString();
    @Column(nullable = false, unique = true)
    private String username;
    @Column(name = "full_name", nullable = false)
    private String fullName;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "company")
    private String company;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "user_role", joinColumns = {
//            @JoinColumn(name = "user_id", referencedColumnName = "id")
//    }, inverseJoinColumns = {
//            @JoinColumn(name = "role_id", referencedColumnName = "id")
//    })
//    private List<Role> roles;
//
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<Job> jobs;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
