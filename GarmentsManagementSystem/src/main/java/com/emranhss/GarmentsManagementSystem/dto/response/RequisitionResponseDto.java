package com.emranhss.GarmentsManagementSystem.dto.response;

import com.emranhss.GarmentsManagementSystem.enums.RequisitionStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class RequisitionResponseDto {
    private Long id;

    private LocalDate prDate;

    private String department;

    private String requestedBy;

    private String categoryName;

    private String orderId;

    private BigDecimal quantity;

    private BigDecimal unitPrice;

    private BigDecimal totalPrice;

    private RequisitionStatus status;
}
