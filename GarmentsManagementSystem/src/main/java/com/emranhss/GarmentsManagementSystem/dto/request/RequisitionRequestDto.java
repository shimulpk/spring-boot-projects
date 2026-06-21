package com.emranhss.GarmentsManagementSystem.dto.request;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class RequisitionRequestDto {
    private LocalDate prDate;

    private String department;

    private String requestedBy;

    private String categoryName;

    private String orderId;

    private BigDecimal quantity;

    private BigDecimal unitPrice;
}
