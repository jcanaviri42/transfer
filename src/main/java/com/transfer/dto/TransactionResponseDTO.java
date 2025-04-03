package com.transfer.dto;

import java.util.Date;

public record TransactionResponseDTO(
        Long id,
        String name,
        Integer nroTransaction,
        Double amount,
        String type,
        Date date
) {
}
