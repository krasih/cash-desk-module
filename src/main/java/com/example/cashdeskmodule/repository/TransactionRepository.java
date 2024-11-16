package com.example.cashdeskmodule.repository;

import com.example.cashdeskmodule.model.Transaction;

import java.util.List;

public interface TransactionRepository {

    Transaction save(Transaction transaction);

    void deleteAll();

    List<Transaction> findAll();

}
