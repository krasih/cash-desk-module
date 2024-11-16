package com.example.cashdeskmodule.service;

import com.example.cashdeskmodule.model.dto.TransactionRequestDTO;

public interface TransactionsService {

    String handleOperation(TransactionRequestDTO transactionRequest);

}
