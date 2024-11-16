package com.example.cashdeskmodule.model.dto;

import com.example.cashdeskmodule.model.enums.Currency;
import com.example.cashdeskmodule.model.enums.Denomination;

import java.time.LocalDateTime;
import java.util.Map;

public class BalanceCheckResponseDTO {

    private String cashier;
    private LocalDateTime date;
    private Currency currency;
    private int totalAmount;
    private Map<Denomination, Integer> denominations;

    public BalanceCheckResponseDTO() {}

    public LocalDateTime getDate() {
        return date;
    }

    public String getCashier() {
        return cashier;
    }

    public BalanceCheckResponseDTO setCashier(String cashier) {
        this.cashier = cashier;
        return this;
    }

    public BalanceCheckResponseDTO setDate(LocalDateTime date) {
        this.date = date;
        return this;
    }

    public Currency getCurrency() {
        return currency;
    }

    public BalanceCheckResponseDTO setCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public BalanceCheckResponseDTO setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    public Map<Denomination, Integer> getDenominations() {
        return denominations;
    }

    public BalanceCheckResponseDTO setDenominations(Map<Denomination, Integer> denominations) {
        this.denominations = denominations;
        return this;
    }
}
