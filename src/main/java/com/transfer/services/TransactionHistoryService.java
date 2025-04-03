package com.transfer.services;

import com.transfer.dto.PaginatedTransactionResponseDTO;
import com.transfer.dto.TransactionResponseDTO;
import com.transfer.mappers.TransactionMapper;
import com.transfer.model.TransactionHistory;
import com.transfer.respository.TransactionHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionHistoryService {

    private final TransactionHistoryRepository transactionHistoryRepository;

    private final TransactionMapper transactionMapper;

    public PaginatedTransactionResponseDTO getAll(Pageable pageable) {
        Page<TransactionHistory> transactions = this.transactionHistoryRepository.findAll(pageable);
        Page<TransactionResponseDTO> transactionPage = transactions
                .map(this.transactionMapper::toTransactionResponseDTO);

        return new PaginatedTransactionResponseDTO(
                transactionPage.getContent(),
                transactionPage.getNumber(),
                transactionPage.getSize(),
                transactionPage.getTotalElements(),
                transactionPage.getTotalPages()
        );
    }
}
