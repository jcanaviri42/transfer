package com.transfer.services;

import com.transfer.dto.TransactionResponseDTO;
import com.transfer.mappers.TransactionMapper;
import com.transfer.model.TransactionHistory;
import com.transfer.respository.TransactionHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@SuppressWarnings("unused")
public class TransactionHistoryService {

    @Autowired
    private TransactionHistoryRepository transactionHistoryRepository;
    @Autowired
    private TransactionMapper transactionMapper;

    public List<TransactionResponseDTO> getAll() {
        List<TransactionHistory> transactions = this.transactionHistoryRepository.findAll();
        return transactions.stream().map(this.transactionMapper::toTransactionResponseDTO).toList();
    }
}
