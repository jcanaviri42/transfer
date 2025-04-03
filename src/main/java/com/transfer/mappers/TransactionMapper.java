package com.transfer.mappers;

import com.transfer.dto.TransactionResponseDTO;
import com.transfer.model.TransactionDay;
import com.transfer.model.TransactionHistory;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {

    public TransactionResponseDTO toTransactionResponseDTO(TransactionDay transactionDay) {
        return new TransactionResponseDTO(
                transactionDay.getId(),
                transactionDay.getName(),
                transactionDay.getNroTransaction(),
                transactionDay.getAmount(),
                transactionDay.getType(),
                transactionDay.getDate()
        );
    }

    public TransactionResponseDTO toTransactionResponseDTO(TransactionHistory transactionHistory) {
        return new TransactionResponseDTO(
                transactionHistory.getId(),
                transactionHistory.getName(),
                transactionHistory.getNroTransaction(),
                transactionHistory.getAmount(),
                transactionHistory.getType(),
                transactionHistory.getDate()
        );
    }

    public TransactionHistory toTransactionHistory(TransactionDay transactionDay) {
        return TransactionHistory.builder()
                .name(transactionDay.getName())
                .nroTransaction(transactionDay.getNroTransaction())
                .type(transactionDay.getType())
                .date(transactionDay.getDate())
                .build();
    }

}
