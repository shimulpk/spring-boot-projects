package com.emranhss.GarmentsManagementSystem.dto.request;

import com.emranhss.GarmentsManagementSystem.enums.TransactionType;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class StockTransactionRequestDto {
    private Long inventoryId;

    private TransactionType transactionType;

    private BigDecimal quantity;

    private LocalDate transactionDate;
}
