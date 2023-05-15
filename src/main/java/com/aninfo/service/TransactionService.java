package com.aninfo.service;

import com.aninfo.model.Account;
import com.aninfo.model.Transaction;
import com.aninfo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Optional;

public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
    public Collection<Transaction> getTransactions() {
        return transactionRepository.findAll();

    }
//    public Optional<Transaction> findByNumber(Long cbu) {
//        return transactionRepository.findByNumber(cbu);
//    }
//

}
