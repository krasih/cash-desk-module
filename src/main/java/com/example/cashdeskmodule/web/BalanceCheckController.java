package com.example.cashdeskmodule.web;

import com.example.cashdeskmodule.model.dto.BalanceCheckResponseDTO;
import com.example.cashdeskmodule.service.BalanceCheckService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class BalanceCheckController {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private final BalanceCheckService balanceCheckService;

    public BalanceCheckController(BalanceCheckService balanceCheckService) {

        this.balanceCheckService = balanceCheckService;
    }

    @GetMapping("cash-balance")
    public ResponseEntity<List<BalanceCheckResponseDTO>> getBalances(
            @RequestParam(required = false) String cashier,
            @RequestParam(required = false) String dateFrom,
            @RequestParam(required = false) String dateTo
    ) {

        List<BalanceCheckResponseDTO> balances =
                balanceCheckService.getBalances(cashier, parse(dateFrom, true), parse(dateTo, false));

        return ResponseEntity.ok(balances);
    }

    private LocalDateTime parse(String date, boolean atStartOfDay) {

        if (date == null) return null;

        // TODO: handle the DateTimeParseException
//        LocalDate localDate = LocalDate.parse(date, formatter);


        LocalDate localDate = null;
        try {
            localDate = LocalDate.parse(date, formatter);
        } catch (Exception e) {
            throw new DateTimeParseException("Provided date ("+date+") is not in the right format. The correct format is yyyy-MM-dd", "ex", 0);
        }

        return atStartOfDay ? localDate.atStartOfDay() : localDate.atTime(LocalTime.MAX);
    }
}
