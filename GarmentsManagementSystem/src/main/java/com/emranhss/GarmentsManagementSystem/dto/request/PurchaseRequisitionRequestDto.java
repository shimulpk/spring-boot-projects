package com.emranhss.GarmentsManagementSystem.dto.request;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class PurchaseRequisitionRequestDto {

    private LocalDate requisitionDate;

    private String requestedBy;

    private String department;

    private String remarks;

    private List<PurchaseRequisitionItemRequestDto> items;
}
