package com.example.cashdeskmodule.init;

import com.example.cashdeskmodule.model.Balance;
import com.example.cashdeskmodule.model.Cashier;
import com.example.cashdeskmodule.repository.BalanceRepository;
import com.example.cashdeskmodule.repository.CashierRepository;
import com.example.cashdeskmodule.repository.TransactionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SampleDataLoader implements CommandLineRunner {

    private static final String ALT_FILE_PATH = "src/main/resources/static/initialSampleData.txt";

    private final BalanceRepository balanceRepository;
    private final CashierRepository cashierRepository;
    private final TransactionRepository transactionRepository;

    public SampleDataLoader(BalanceRepository balanceRepository, CashierRepository cashierRepository,
                            TransactionRepository transactionRepository) {

        this.balanceRepository = balanceRepository;
        this.cashierRepository = cashierRepository;
        this.transactionRepository = transactionRepository;
    }


    @Override
    public void run(String... args) {

        List<Cashier> allCashiers = cashierRepository.findAll();

        if (allCashiers.size() > 0) return;

        cashierRepository.deleteAll();
        balanceRepository.deleteAll();
        transactionRepository.deleteAll();

        allCashiers = cashierRepository.findAll(ALT_FILE_PATH);

        cashierRepository.save(allCashiers);

        for (Cashier cashier : allCashiers) {

            List<Balance> cashierBalances = cashier.getBalances().values().stream()
                    .map(balance -> balance.setDate(LocalDateTime.now()))
                    .collect(Collectors.toList());

            balanceRepository.save(cashierBalances);
        }
    }
}
