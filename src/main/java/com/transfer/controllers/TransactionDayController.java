package com.transfer.controllers;

import com.transfer.dto.TransactionDTO;
import com.transfer.dto.TransactionResponseDTO;
import com.transfer.services.TransactionDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions-day")
@SuppressWarnings("unused")
public class TransactionDayController {
    @Autowired
    private TransactionDayService transactionDayService;

    @PostMapping
    public ResponseEntity<TransactionResponseDTO> insert(
            @RequestBody TransactionDTO transaction) {

        TransactionResponseDTO savedTransaction = this.transactionDayService.insert(transaction);
        return new ResponseEntity<>(savedTransaction, HttpStatus.CREATED);
    }

}
