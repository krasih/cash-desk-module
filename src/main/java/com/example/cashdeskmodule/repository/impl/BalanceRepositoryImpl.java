package com.example.cashdeskmodule.repository.impl;

import com.example.cashdeskmodule.model.Balance;
import com.example.cashdeskmodule.repository.BalanceRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BalanceRepositoryImpl implements BalanceRepository {

    private static final String FILE_PATH = "src/main/resources/static/balances.txt";

    @Override
    public Balance save(Balance balance) {

        return GenericRepository.save(balance, FILE_PATH);
    }

    @Override
    public void save(List<Balance> balances) {

        balances.forEach(this::save);
    }

    @Override
    public void deleteAll() {

        GenericRepository.deleteContent(FILE_PATH);
    }

    @Override
    public List<Balance> findAll() {

        return GenericRepository.findAll(FILE_PATH, Balance.class);
    }

    @Override
    public List<Balance> findByCashier(String cashier) {

        return findAll().stream()
                .filter(c -> c.getCashier().equalsIgnoreCase(cashier))
                .collect(Collectors.toList());
    }

    public List<Balance> findByCriteria(String cashier, LocalDateTime dateFrom, LocalDateTime dateTo) {
        // ... existing implementation to fetch all balances

        return findAll().stream()
                .filter(balance -> {
                    boolean matchesCashier = cashier == null || balance.getCashier().equalsIgnoreCase(cashier);
                    boolean matchesDateFrom = dateFrom == null || balance.getDate().isAfter(dateFrom);
                    boolean matchesDateTo = dateTo == null || balance.getDate().isBefore(dateTo);
                    return matchesCashier && matchesDateFrom && matchesDateTo;
                })
                .collect(Collectors.toList());
    }
}
