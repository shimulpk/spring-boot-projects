package com.emranhss.GarmentsManagementSystem.dto.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DayWiseFinishingProductionResponseDto {

    private Long id;

    private Long finishingPlanId;

    private String finishingPlanCode;

    private LocalDate date;

    private Integer passQty;

    private Integer rejectQty;

    private String remarks;

    private String styleNo;

    private String buyerName;
}
