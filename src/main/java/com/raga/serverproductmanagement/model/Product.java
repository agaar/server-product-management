package com.raga.serverproductmanagement.model;

import lombok.Data;

import javax.persistence.*;

@Data //auto getters, setters, equals, hashcode
@Entity //defines that a class can be mapped to a table
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="price")
    private Double price;

    @Column(name="explanation")
    private String explanation;

}
