package com.example.cashdeskmodule.service;

import com.example.cashdeskmodule.model.dto.BalanceCheckResponseDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface BalanceCheckService {

    List<BalanceCheckResponseDTO> getBalances(String cashier, LocalDateTime dateFrom, LocalDateTime dateTo);

}
