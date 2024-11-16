package com.example.cashdeskmodule.repository.impl;

import com.example.cashdeskmodule.model.Cashier;
import com.example.cashdeskmodule.repository.CashierRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CashierRepositoryImpl implements CashierRepository {

    private static final String FILE_PATH = "src/main/resources/static/cashiers.txt";

    @Override
    public Cashier save(Cashier cashier) {

        return GenericRepository.save(cashier, FILE_PATH);
    }

    @Override
    public void save(List<Cashier> cashiers) {

        cashiers.forEach(this::save);
    }

    @Override
    public void deleteAll() {

        GenericRepository.deleteContent(FILE_PATH);
    }

    @Override
    public Cashier update(Cashier updatedCashier) {

        List<Cashier> cashiers = findAll();

        Optional<Cashier> found = findByName(updatedCashier.getName());

        if (found.isPresent()) {
            int index = cashiers.indexOf(found.get());
            cashiers.set(index, updatedCashier);
            deleteAll();
            save(cashiers);
        } else {
            save(updatedCashier);
        }

        return updatedCashier;
    }

    @Override
    public List<Cashier> findAll() {

        return GenericRepository.findAll(FILE_PATH, Cashier.class);
    }

    @Override
    public List<Cashier> findAll(String filePath) {

        return GenericRepository.findAll(filePath, Cashier.class);
    }

    @Override
    public Optional<Cashier> findByName(String cashierName) {

        return findAll().stream()
                .filter(cashier -> cashier.getName().equalsIgnoreCase(cashierName))
                .findFirst();
    }
}
