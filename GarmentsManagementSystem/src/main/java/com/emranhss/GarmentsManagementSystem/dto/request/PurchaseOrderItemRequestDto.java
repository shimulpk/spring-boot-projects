package com.emranhss.GarmentsManagementSystem.dto.request;

import lombok.Data;

@Data
public class PurchaseOrderItemRequestDto {

    private Long itemId;

    private Double quantity;

    private Double unitPrice;

    private String remarks;

}
