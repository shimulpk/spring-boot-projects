package com.emranhss.GarmentsManagementSystem.dto.response;

import com.emranhss.GarmentsManagementSystem.enums.ProcurementPoStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ProcurementPoResponseDto {

    private Long id;

    private String poNumber;

    private LocalDate poDate;

    private LocalDate deliveryDate;

    private Long vendorId;
    private String vendorName;
    private String vendorPhone;

    private Long requisitionId;

    private String productName;

    private BigDecimal quantity;

    private BigDecimal unitPrice;

    private BigDecimal taxPercent;

    private BigDecimal totalPrice;

    private ProcurementPoStatus status;
}
