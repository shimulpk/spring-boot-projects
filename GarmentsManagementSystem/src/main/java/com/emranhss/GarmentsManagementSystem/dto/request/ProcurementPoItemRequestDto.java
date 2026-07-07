package com.emranhss.GarmentsManagementSystem.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProcurementPoItemRequestDto {

    private String materialName;

    private String unit;

    private BigDecimal quantity;

    private BigDecimal unitPrice;
}
