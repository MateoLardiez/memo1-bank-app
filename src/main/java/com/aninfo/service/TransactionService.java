package com.aninfo.service;

import com.aninfo.model.Transaction;
import com.aninfo.model.TransactionType;
import com.aninfo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private AccountService accountService;

    @Transactional
    public Transaction createTransaction(Long cbu, TransactionType type, Double amount) {
        Transaction transaction = new Transaction(cbu,type,amount);

        if(transaction.getType() == TransactionType.deposit){
            accountService.deposit(transaction.getCbu(), transaction.getAmount());
        } else if (transaction.getType() == TransactionType.withdraw){
            accountService.withdraw(transaction.getCbu(), transaction.getAmount());
        }
        return transactionRepository.save(transaction);
    }

    @Transactional
    public Collection<Transaction> getTransactionsByCbu(Long cbu) {
        return transactionRepository.findTransactionsByCbu(cbu);
    }

    public void deleteById(Long id) {
        transactionRepository.deleteById(id);
    }
//

}
