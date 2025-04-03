package com.transfer.services;

import com.transfer.dto.TransactionResponseDTO;
import com.transfer.mappers.TransactionMapper;
import com.transfer.model.TransactionHistory;
import com.transfer.respository.TransactionHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class TransactionHistoryService {

    private final TransactionHistoryRepository transactionHistoryRepository;

    private final TransactionMapper transactionMapper;

    public List<TransactionResponseDTO> getAll() {
        List<TransactionHistory> transactions = this.transactionHistoryRepository.findAll();
        return transactions.stream().map(this.transactionMapper::toTransactionResponseDTO).toList();
    }
}
