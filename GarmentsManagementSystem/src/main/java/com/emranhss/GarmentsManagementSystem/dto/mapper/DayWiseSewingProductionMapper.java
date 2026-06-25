package com.emranhss.GarmentsManagementSystem.dto.mapper;


import com.emranhss.GarmentsManagementSystem.dto.request.DayWiseSewingProductionRequestDto;
import com.emranhss.GarmentsManagementSystem.dto.response.DayWiseSewingProductionResponseDto;
import com.emranhss.GarmentsManagementSystem.entity.DayWiseSewingProduction;

public class DayWiseSewingProductionMapper {
    public static DayWiseSewingProduction toEntity(DayWiseSewingProductionRequestDto requestDto){

        DayWiseSewingProduction production = new DayWiseSewingProduction();

        production.setDate(requestDto.getDate());
        production.setAchievedQuantity(requestDto.getAchievedQuantity());
        production.setRejectionQty(requestDto.getRejectionQty());
        return production;
    }

    public static DayWiseSewingProductionResponseDto toDto(DayWiseSewingProduction production){

      DayWiseSewingProductionResponseDto responseDto = new DayWiseSewingProductionResponseDto();
      responseDto.setId(production.getId());
      responseDto.setSewingPlanId(production.getId());
      responseDto.setSewingPlanCode(production.getSewingPlan().getSewingPlanId());
      return responseDto;
    }
}
