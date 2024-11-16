package com.example.cashdeskmodule.model.dto;

import com.example.cashdeskmodule.model.enums.Currency;
import com.example.cashdeskmodule.model.enums.Denomination;
import com.example.cashdeskmodule.model.enums.TransactionType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.Map;

public class TransactionRequestDTO {

    @NotNull(message = "null")
    @NotEmpty(message = "empty")
    @NotBlank(message = "blank")
    private String cashier;

    @NotNull
    private TransactionType type;

    @NotNull
    private Currency currency;

    @NotNull
    @Positive
    private int amount;

    @NotNull
    private Map<Denomination, Integer> denominations;

    public TransactionRequestDTO() {}

    public String getCashier() {
        return cashier;
    }

    public TransactionRequestDTO setCashier(String cashier) {
        this.cashier = cashier;
        return this;
    }

    public TransactionType getType() {
        return type;
    }

    public TransactionRequestDTO setType(TransactionType type) {
        this.type = type;
        return this;
    }

    public Currency getCurrency() {
        return currency;
    }

    public TransactionRequestDTO setCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }

    public int getAmount() {
        return amount;
    }

    public TransactionRequestDTO setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public Map<Denomination, Integer> getDenominations() {
        return denominations;
    }

    public TransactionRequestDTO setDenominations(Map<Denomination, Integer> denominations) {
        this.denominations = denominations;
        return this;
    }
}
