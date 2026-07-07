package com.emranhss.GarmentsManagementSystem.dto.response;

import lombok.Data;

@Data
public class PurchaseRequisitionItemResponseDto {

    private Long id;

    private Long itemId;

    private String itemName;

    private String uom;

    private Double quantity;

    private String remarks;
}
