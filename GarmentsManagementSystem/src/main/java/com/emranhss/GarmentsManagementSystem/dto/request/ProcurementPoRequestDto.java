package com.emranhss.GarmentsManagementSystem.dto.request;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ProcurementPoRequestDto {
    private String poNumber;

    private LocalDate poDate;

    private LocalDate deliveryDate;

    private Long vendorId;

    private Long requisitionId;

//    private String productName;
//
//    private BigDecimal quantity;
//
//    private BigDecimal unitPrice;

    private BigDecimal taxPercent;
}
