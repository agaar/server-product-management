package com.raga.serverproductmanagement.repository;

import com.raga.serverproductmanagement.model.Transaction;
import com.raga.serverproductmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransactionRepository extends JpaRepository <Transaction, Long> { //model class, id class


}
