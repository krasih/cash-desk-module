package com.example.cashdeskmodule.model;

import com.example.cashdeskmodule.model.enums.Currency;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
public class Cashier {

    private String name;
    private Map<Currency, Balance> balances = new HashMap<>();

    public Cashier() {}

    public String getName() {
        return name;
    }

    public Cashier setName(String name) {
        this.name = name;
        return this;
    }

    public Map<Currency, Balance> getBalances() {
        return balances;
    }

    public Cashier setBalances(Map<Currency, Balance> balances) {
        this.balances = balances;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cashier cashier = (Cashier) o;

        return Objects.equals(name, cashier.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
