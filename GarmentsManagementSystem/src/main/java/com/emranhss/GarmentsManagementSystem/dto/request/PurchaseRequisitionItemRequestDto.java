package com.emranhss.GarmentsManagementSystem.dto.request;

import lombok.Data;

@Data
public class PurchaseRequisitionItemRequestDto {

    private Long itemId;

    private Double quantity;

    private String remarks;
}
