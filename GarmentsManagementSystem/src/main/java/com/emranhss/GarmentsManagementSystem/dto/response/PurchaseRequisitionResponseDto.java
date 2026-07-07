package com.emranhss.GarmentsManagementSystem.dto.response;

import com.emranhss.GarmentsManagementSystem.enums.PurchaseRequisitionStatus;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class PurchaseRequisitionResponseDto {

    private Long id;

    private String prNo;

    private LocalDate requisitionDate;

    private String requestedBy;

    private String department;

    private String remarks;

    private PurchaseRequisitionStatus status;

    private List<PurchaseRequisitionItemResponseDto> items;
}
