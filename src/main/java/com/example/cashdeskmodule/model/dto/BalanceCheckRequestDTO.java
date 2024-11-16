package com.example.cashdeskmodule.model.dto;

import java.time.LocalDateTime;

public class BalanceCheckRequestDTO {

    private LocalDateTime dateFrom;
    private LocalDateTime dateTo;
    private String cashier;

    public BalanceCheckRequestDTO() {}

    public LocalDateTime getDateFrom() {
        return dateFrom;
    }

    public BalanceCheckRequestDTO setDateFrom(LocalDateTime dateFrom) {
        this.dateFrom = dateFrom;
        return this;
    }

    public LocalDateTime getDateTo() {
        return dateTo;
    }

    public BalanceCheckRequestDTO setDateTo(LocalDateTime dateTo) {
        this.dateTo = dateTo;
        return this;
    }

    public String getCashier() {
        return cashier;
    }

    public BalanceCheckRequestDTO setCashier(String cashier) {
        this.cashier = cashier;
        return this;
    }
}
