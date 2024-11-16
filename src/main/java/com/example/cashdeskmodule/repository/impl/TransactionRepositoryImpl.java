package com.example.cashdeskmodule.repository.impl;

import com.example.cashdeskmodule.model.Transaction;
import com.example.cashdeskmodule.repository.TransactionRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {

    private static final String FILE_PATH = "src/main/resources/static/transactions.txt";

    @Override
    public Transaction save(Transaction transaction) {

        return GenericRepository.save(transaction, FILE_PATH);
    }

    @Override
    public void deleteAll() {

        GenericRepository.deleteContent(FILE_PATH);
    }

    @Override
    public List<Transaction> findAll() {

        return GenericRepository.findAll(FILE_PATH, Transaction.class);
    }
}
