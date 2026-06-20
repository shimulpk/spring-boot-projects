package com.emranhss.GarmentsManagementSystem.dto.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class InventoryResponseDto {
    private Long id;

    private Long itemId;

    private String itemName;

    private String category;

    private String unit;

    private BigDecimal quantity;
}
