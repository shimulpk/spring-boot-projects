package com.emranhss.GarmentsManagementSystem.dto.response;

import lombok.Data;

@Data
public class CuttingPlanProgressResponseDto {
    private Integer target;

    private Integer cutSoFar;

    private Integer remaining;

    private Double progress;
}
