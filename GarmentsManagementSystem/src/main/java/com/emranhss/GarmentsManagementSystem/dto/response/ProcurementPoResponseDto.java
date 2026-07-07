package com.emranhss.GarmentsManagementSystem.dto.response;

import com.emranhss.GarmentsManagementSystem.enums.ProcurementPoStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
public class ProcurementPoResponseDto {

    private Long id;

    private String poNumber;

    private LocalDate poDate;

    private LocalDate deliveryDate;

    private Long vendorId;

    private String vendorName;

    private Long requisitionId;

    private BigDecimal taxPercent;

    private BigDecimal subTotal;

    private BigDecimal taxAmount;

    private BigDecimal grandTotal;

    private ProcurementPoStatus status;

    private List<ProcurementPoItemResponseDto> items;
}
