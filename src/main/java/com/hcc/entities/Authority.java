package com.hcc.entities;

import javax.persistence.*;

@Entity
@Table(name="authority")
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "authority")
    private String authority;
    @Column(name="user")
    private User user;

}
