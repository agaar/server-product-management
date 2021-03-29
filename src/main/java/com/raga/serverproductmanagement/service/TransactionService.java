package com.raga.serverproductmanagement.service;

import com.raga.serverproductmanagement.model.Transaction;

import java.util.List;

public interface TransactionService {
    Transaction saveTransaction(Transaction transaction);

    Long numberOfTransations();

    List<Transaction> findAllTransaction();
}
