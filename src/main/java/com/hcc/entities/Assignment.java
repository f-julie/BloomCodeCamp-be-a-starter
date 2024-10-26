package com.hcc.entities;

import javax.persistence.*;

@Entity
@Table(name="assignment")
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "status")
    private String status;
    @Column(name = "number")
    private Integer number;
    @Column(name = "githubUrl")
    private String githubUrl;
    @Column(name = "branch")
    private String branch;
    @Column(name = "reviewVideoUrl")
    private String reviewVideoUrl;
    @Column(name = "user")
    private User user;

    // No args constructor
    public Assignment() {
    }

    // All args except id constructor
    public Assignment(String status, Integer number, String githubUrl, String branch, String reviewVideoUrl, User user) {
        this.status = status;
        this.number = number;
        this.githubUrl = githubUrl;
        this.branch = branch;
        this.reviewVideoUrl = reviewVideoUrl;
        this.user = user;
    }
}
