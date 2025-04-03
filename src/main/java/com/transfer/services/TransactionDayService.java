package com.transfer.services;

import com.transfer.dto.TransactionDTO;
import com.transfer.dto.TransactionResponseDTO;
import com.transfer.mappers.TransactionMapper;
import com.transfer.model.TransactionDay;
import com.transfer.respository.TransactionDayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("unused")
public class TransactionDayService {

    @Autowired
    private TransactionDayRepository transactionDayRepository;
    @Autowired
    private TransactionMapper transactionMapper;

    public TransactionResponseDTO insert(TransactionDTO transactionDTO) {
        TransactionDay newTransaction = TransactionDay.builder()
                .name(transactionDTO.name())
                .nroTransaction(transactionDTO.nroTransaction())
                .amount(transactionDTO.amount())
                .type(transactionDTO.type())
                .date(transactionDTO.date())
                .build();

        this.transactionDayRepository.save(newTransaction);
        return this.transactionMapper.toTransactionResponseDTO(newTransaction);
    }
}
