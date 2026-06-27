package com.emranhss.GarmentsManagementSystem.dto.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DayWisePackingProductionResponseDto {

    private Long id;

    private Long packingPlanId;

    private String packingPlanCode;

    private String buyerName;

    private String orderNo;

    private String styleNo;

    private LocalDate date;

    private Integer todayPackedQty;

    private Integer todayPackedCartons;

    private Integer todayRejectQty;
}
