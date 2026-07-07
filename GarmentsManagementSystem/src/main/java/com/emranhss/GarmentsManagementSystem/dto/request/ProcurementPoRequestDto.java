package com.emranhss.GarmentsManagementSystem.dto.request;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
public class ProcurementPoRequestDto {
    private String poNumber;

    private LocalDate poDate;

    private LocalDate deliveryDate;

    private Long vendorId;

    private Long requisitionId;

    private BigDecimal taxPercent;

    private List<ProcurementPoItemRequestDto> items;
}
