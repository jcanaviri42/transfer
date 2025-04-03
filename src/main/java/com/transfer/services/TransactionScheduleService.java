package com.transfer.services;

import com.transfer.mappers.TransactionMapper;
import com.transfer.model.TransactionDay;
import com.transfer.model.TransactionHistory;
import com.transfer.respository.TransactionDayRepository;
import com.transfer.respository.TransactionHistoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionScheduleService {

    private final TransactionDayRepository transactionDayRepository;

    private final TransactionHistoryRepository transactionHistoryRepository;

    private final TransactionMapper transactionMapper;

    @Transactional
    public void transferData() {
        System.out.println("⌚ Running schedule task...");

        List<TransactionDay> transactions = transactionDayRepository.findAll();
        List<TransactionHistory> transactionHistories = transactions
                .stream()
                .map(this.transactionMapper::toTransactionHistory)
                .toList();

        transactionHistoryRepository.saveAll(transactionHistories);
        this.transactionDayRepository.deleteAll();
        this.transactionDayRepository.truncateTransactionDay();
    }

}
