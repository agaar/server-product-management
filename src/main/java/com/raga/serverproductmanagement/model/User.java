package com.raga.serverproductmanagement.model;

import lombok.Data;

import javax.persistence.*;

@Data //auto getters, setters, equals, hashcode
@Entity //defines that a class can be mapped to a table
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name="role")
    private Role role;

    @Transient //field is not to be persisted in the database
    private String token;
}
