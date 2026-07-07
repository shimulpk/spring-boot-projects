package com.emranhss.GarmentsManagementSystem.dto.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProcurementPoItemResponseDto {

    private Long id;

    private String materialName;

    private String unit;

    private BigDecimal quantity;

    private BigDecimal unitPrice;

    private BigDecimal lineTotal;
}
