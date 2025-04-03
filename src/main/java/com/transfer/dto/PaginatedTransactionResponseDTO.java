package com.transfer.dto;

import java.util.List;

public record PaginatedTransactionResponseDTO(
        List<TransactionResponseDTO> content,
        int pageNumber,
        int pageSize,
        long totalElements,
        int totalPages
) {
}
