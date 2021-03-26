package com.raga.serverproductmanagement.model;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
    private Long id;
}
