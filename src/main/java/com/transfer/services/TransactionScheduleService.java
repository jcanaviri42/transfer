package com.transfer.services;

import com.transfer.mappers.TransactionMapper;
import com.transfer.model.TransactionDay;
import com.transfer.model.TransactionHistory;
import com.transfer.respository.TransactionDayRepository;
import com.transfer.respository.TransactionHistoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@SuppressWarnings("unused")
public class TransactionScheduleService {

    @Autowired
    private TransactionDayRepository transactionDayRepository;
    @Autowired
    private TransactionHistoryRepository transactionHistoryRepository;
    @Autowired
    private TransactionMapper transactionMapper;

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
