package com.raga.serverproductmanagement.service;

import com.raga.serverproductmanagement.model.Transaction;
import com.raga.serverproductmanagement.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional //support transaction management
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    // injects the dependent beans into the associated references of a POJO class by matching the data-type
    private TransactionRepository transactionRepository;

    @Override
    public Transaction saveTransaction(final Transaction transaction){
        return transactionRepository.save(transaction);
    }

    @Override
    public Long numberOfTransations(){
        return transactionRepository.count();
    }

    @Override
    public List<Transaction> findAllTransaction(){
        return transactionRepository.findAll();
    }
}
