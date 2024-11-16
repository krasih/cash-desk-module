package com.example.cashdeskmodule.web;

import com.example.cashdeskmodule.model.dto.TransactionRequestDTO;
import com.example.cashdeskmodule.service.TransactionsService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class TransactionsController {

    private final TransactionsService transactionsService;

    public TransactionsController(TransactionsService transactionsService) {
        this.transactionsService = transactionsService;
    }

    @PostMapping("cash-operation")
    public ResponseEntity<String> handleTransaction(@Valid @RequestBody TransactionRequestDTO request) {

        transactionsService.handleOperation(request);
        return ResponseEntity.ok("Transaction completed successfully.");
    }

}
