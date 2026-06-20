package com.emranhss.GarmentsManagementSystem.dto.response;

import com.emranhss.GarmentsManagementSystem.enums.TransactionType;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class StockTransactionResponseDto {

    private Long id;

    private Long inventoryId;

    private String itemName;

    private TransactionType transactionType;

    private BigDecimal quantity;

    private LocalDate transactionDate;

    private LocalDateTime createdAt;
}
