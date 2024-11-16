package com.example.cashdeskmodule.repository;

import com.example.cashdeskmodule.model.Balance;
import com.example.cashdeskmodule.model.Cashier;

import java.util.List;
import java.util.Optional;

public interface CashierRepository {

    Cashier save(Cashier cashier);

    void save(List<Cashier> balances);

    Cashier update(Cashier cashier);

    void deleteAll();

    List<Cashier> findAll();

    List<Cashier> findAll(String filePath);

    Optional<Cashier> findByName(String cashierName);

}
