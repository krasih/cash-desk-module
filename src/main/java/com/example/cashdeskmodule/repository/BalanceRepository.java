package com.example.cashdeskmodule.repository;

import com.example.cashdeskmodule.model.Balance;
import com.example.cashdeskmodule.model.Cashier;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface BalanceRepository {

    Balance save(Balance balance);
    void save(List<Balance> balances);

    void deleteAll();

    List<Balance> findAll();

    List<Balance> findByCashier(String cashier);

    List<Balance> findByCriteria(String cashier, LocalDateTime dateFrom, LocalDateTime dateTo);

}
