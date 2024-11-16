package com.example.cashdeskmodule.model;

import com.example.cashdeskmodule.model.enums.Currency;
import com.example.cashdeskmodule.model.enums.Denomination;
import com.example.cashdeskmodule.model.enums.TransactionType;

import java.time.LocalDateTime;
import java.util.Map;

public class Transaction {

    private LocalDateTime date;
    private String cashier;
    private TransactionType type;
    private Currency currency;
    private int amount;
    private Map<Denomination, Integer> denominations;

    public Transaction() {}

    public LocalDateTime getDate() {
        return date;
    }

    public Transaction setDate(LocalDateTime date) {
        this.date = date;
        return this;
    }

    public String getCashier() {
        return cashier;
    }

    public Transaction setCashier(String cashier) {
        this.cashier = cashier;
        return this;
    }

    public TransactionType getType() {
        return type;
    }

    public Transaction setType(TransactionType type) {
        this.type = type;
        return this;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Transaction setCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }

    public int getAmount() {
        return amount;
    }

    public Transaction setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public Map<Denomination, Integer> getDenominations() {
        return denominations;
    }

    public Transaction setDenominations(Map<Denomination, Integer> denominations) {
        this.denominations = denominations;
        return this;
    }

    @Override
    public String toString() {
        return "Transaction completed successfully: {" +
                "date=" + date +
                ", cashier='" + cashier + '\'' +
                ", type=" + type +
                ", currency=" + currency +
                ", amount=" + amount +
                ", denominations=" + denominations +
                '}';
    }
}
