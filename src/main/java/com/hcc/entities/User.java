package com.hcc.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="cohortStartDate")
    private LocalDate cohortStartDate;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;

    // No args constructor
    public User() {
    }

    // All args except id constructor
    public User(LocalDate cohortStartDate, String username, String password) {
        this.cohortStartDate = cohortStartDate;
        this.username = username;
        this.password = password;
    }
}
