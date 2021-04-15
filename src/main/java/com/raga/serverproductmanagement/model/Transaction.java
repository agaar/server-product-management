package com.raga.serverproductmanagement.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data //auto getters, setters, equals, hashcode
@Entity //defines that a class can be mapped to a table
@Table(name="transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)  //product can have many transactions (can be bought by many users)
    @JoinColumn(name="product_id", referencedColumnName = "id")
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)    //user can have many trans
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;

    @Column(name="purchase_date")
    private LocalDateTime purchaseDate;
}
