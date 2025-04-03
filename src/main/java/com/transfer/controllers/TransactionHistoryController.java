package com.transfer.controllers;

import com.transfer.dto.TransactionResponseDTO;
import com.transfer.services.TransactionHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transactions-history")
@RequiredArgsConstructor
public class TransactionHistoryController {

    private final TransactionHistoryService transactionHistoryService;

    @GetMapping
    public ResponseEntity<List<TransactionResponseDTO>> getAll() {
        List<TransactionResponseDTO> transactions = this.transactionHistoryService.getAll();
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

}
