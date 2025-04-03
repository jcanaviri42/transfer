package com.transfer.controllers;

import com.transfer.dto.PaginatedTransactionResponseDTO;
import com.transfer.services.TransactionHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions-history")
@RequiredArgsConstructor
public class TransactionHistoryController {

    private final TransactionHistoryService transactionHistoryService;

    @GetMapping
    public ResponseEntity<PaginatedTransactionResponseDTO> getAll(
            @PageableDefault(page = 0, size = 5) Pageable pageable
    ) {
        PaginatedTransactionResponseDTO transactions = this.transactionHistoryService.getAll(pageable);
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

}
