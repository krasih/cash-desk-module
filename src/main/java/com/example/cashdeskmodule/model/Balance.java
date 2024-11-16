package com.example.cashdeskmodule.model;

import com.example.cashdeskmodule.model.enums.Currency;
import com.example.cashdeskmodule.model.enums.Denomination;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Map;

@Component
public class Balance {

    private LocalDateTime date;
    private String cashier;
    private Currency currency;
    private int totalAmount;
    private Map<Denomination, Integer> denominations;    // denomination, count

    public Balance() {}

    public Balance(LocalDateTime date, String cashier, Currency currency, int totalAmount, Map<Denomination, Integer> denominations) {
        this.date = date;
        this.cashier = cashier;
        this.currency = currency;
        this.totalAmount = totalAmount;
        this.denominations = denominations;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Balance setDate(LocalDateTime date) {
        this.date = date;
        return this;
    }

    public String getCashier() {
        return cashier;
    }

    public Balance setCashier(String cashier) {
        this.cashier = cashier;
        return this;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Balance setCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public Balance setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    public Map<Denomination, Integer> getDenominations() {
        return denominations;
    }

    public Balance setDenominations(Map<Denomination, Integer> denominations) {
        this.denominations = denominations;
        return this;
    }
}
