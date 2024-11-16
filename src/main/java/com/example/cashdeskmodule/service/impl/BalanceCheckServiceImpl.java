package com.example.cashdeskmodule.service.impl;

import com.example.cashdeskmodule.model.dto.BalanceCheckResponseDTO;
import com.example.cashdeskmodule.repository.BalanceRepository;
import com.example.cashdeskmodule.service.BalanceCheckService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BalanceCheckServiceImpl implements BalanceCheckService {

    private final ModelMapper modelMapper;
    private final BalanceRepository balanceRepository;

    public BalanceCheckServiceImpl(ModelMapper modelMapper, BalanceRepository balanceRepository) {

        this.modelMapper = modelMapper;
        this.balanceRepository = balanceRepository;
    }

    @Override
    public List<BalanceCheckResponseDTO> getBalances(String cashier, LocalDateTime dateFrom, LocalDateTime dateTo) {

        return balanceRepository.findByCriteria(cashier, dateFrom, dateTo)
                .stream()
                .map(balance -> modelMapper.map(balance, BalanceCheckResponseDTO.class))
                .collect(Collectors.toList());
    }
}
