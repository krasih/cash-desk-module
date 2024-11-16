package com.example.cashdeskmodule.service.impl;

import com.example.cashdeskmodule.exceptions.CashierInsufficientBalanceException;
import com.example.cashdeskmodule.exceptions.CashierInsufficientDenominationsException;
import com.example.cashdeskmodule.exceptions.CashierNotExistsException;
import com.example.cashdeskmodule.model.Balance;
import com.example.cashdeskmodule.model.Cashier;
import com.example.cashdeskmodule.model.Transaction;
import com.example.cashdeskmodule.model.dto.TransactionRequestDTO;
import com.example.cashdeskmodule.model.enums.Denomination;
import com.example.cashdeskmodule.repository.BalanceRepository;
import com.example.cashdeskmodule.repository.CashierRepository;
import com.example.cashdeskmodule.repository.TransactionRepository;
import com.example.cashdeskmodule.service.TransactionsService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class TransactionsServiceImpl implements TransactionsService {

    private final ModelMapper modelMapper;
    private final TransactionRepository transactionRepository;
    private final CashierRepository cashierRepository;
    private final BalanceRepository balanceRepository;

    private final Logger logger = LoggerFactory.getLogger(TransactionsServiceImpl.class);

    public TransactionsServiceImpl(ModelMapper modelMapper, TransactionRepository transactionRepository,
                                   CashierRepository cashierRepository, BalanceRepository balanceRepository) {

        this.modelMapper = modelMapper;
        this.transactionRepository = transactionRepository;
        this.cashierRepository = cashierRepository;
        this.balanceRepository = balanceRepository;
    }

    @Override
    public String handleOperation(TransactionRequestDTO transactionRequest) {

        Transaction transaction = modelMapper.map(transactionRequest, Transaction.class).setDate(LocalDateTime.now());
        Optional<Cashier> cashier = cashierRepository.findByName(transaction.getCashier());

        if (cashier.isEmpty()) {
            throw new CashierNotExistsException("Cashier with name: " + transaction.getCashier() + " doesn't exist.");
        }

        switch (transaction.getType()) {
            case DEPOSIT -> deposit(transaction, cashier.get());
            case WITHDRAW -> withdraw(transaction, cashier.get());
        }

        return "Transaction completed successfully!";
    }

    private void deposit(Transaction transaction, Cashier cashier) {

        Balance currentCashierBalance = cashier.getBalances().get(transaction.getCurrency());

        Map<Denomination, Integer> mergedDenominations =
                mergeDenominations(currentCashierBalance.getDenominations(), transaction.getDenominations());

        int updatedTotalAmount = currentCashierBalance.getTotalAmount() + transaction.getAmount();

        Balance updatedBalance = currentCashierBalance
                .setTotalAmount(updatedTotalAmount)
                .setDenominations(mergedDenominations);

        cashierRepository.update(cashier);
        balanceRepository.save(updatedBalance.setDate(LocalDateTime.now()));
        transactionRepository.save(transaction);

        logger.info("----> LOGGER: {} <----", transaction);
    }

    private void withdraw(Transaction transaction, Cashier cashier) {

        Balance currentCashierBalance = cashier.getBalances().get(transaction.getCurrency());

        Map<Denomination, Integer> subtractedDenominations =
                subtractDenominations(currentCashierBalance.getDenominations(), transaction.getDenominations());

        int updatedTotalAmount = currentCashierBalance.getTotalAmount() - transaction.getAmount();

        if (updatedTotalAmount < 0) {
            throw new CashierInsufficientBalanceException("Insufficient balance for cashier with name: " +
                    transaction.getCashier() + " . Transaction couldn't be completed.");
        }

        Balance updatedBalance = currentCashierBalance
                .setTotalAmount(updatedTotalAmount)
                .setDenominations(subtractedDenominations);

        cashierRepository.update(cashier);
        balanceRepository.save(updatedBalance.setDate(LocalDateTime.now()));
        transactionRepository.save(transaction);

        logger.info("----> LOGGER: {} <----", transaction);
    }

    private Map<Denomination, Integer> mergeDenominations(Map<Denomination, Integer> map1, Map<Denomination, Integer> map2) {
        Map<Denomination, Integer> mergedMap = new HashMap<>();

        // Add all denominations from map1
        map1.forEach((denomination, count) -> mergedMap.merge(denomination, count, Integer::sum));

        // Add all denominations from map2, merging with existing ones
        map2.forEach((denomination, count) -> mergedMap.merge(denomination, count, Integer::sum));

        return mergedMap;
    }

    private Map<Denomination, Integer> subtractDenominations(Map<Denomination, Integer> origin, Map<Denomination, Integer> map2) {
        Map<Denomination, Integer> result = new HashMap<>();

        // Iterate over origin map and subtract values from map2
        for (Map.Entry<Denomination, Integer> entry : origin.entrySet()) {
            Denomination denomination = entry.getKey();
            int count1 = entry.getValue();
            int count2 = map2.getOrDefault(denomination, 0);

            int difference = count1 - count2;

            if (difference < 0) {
                throw new CashierInsufficientDenominationsException("Insufficient amount for denomination: " + denomination);
            } else if (difference > 0) {
                result.put(denomination, difference);
            }
        }

        return result;
    }

}
