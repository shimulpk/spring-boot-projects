package com.emranhss.GarmentsManagementSystem.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class InventoryRequestDto {
    private Long itemId;

    private BigDecimal quantity;
}
