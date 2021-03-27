package com.raga.serverproductmanagement.repository;

import com.raga.serverproductmanagement.model.Product;
import com.raga.serverproductmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository <Product, Long> { //model class, id class


}
