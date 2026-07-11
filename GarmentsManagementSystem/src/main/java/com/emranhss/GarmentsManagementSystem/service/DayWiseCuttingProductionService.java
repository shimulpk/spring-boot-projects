package com.emranhss.GarmentsManagementSystem.service;

import com.emranhss.GarmentsManagementSystem.dto.request.DayWiseCuttingProductionRequestDto;
import com.emranhss.GarmentsManagementSystem.dto.response.CuttingPlanProgressResponseDto;
import com.emranhss.GarmentsManagementSystem.dto.response.DayWiseCuttingProductionResponseDto;

import java.util.List;

public interface DayWiseCuttingProductionService {

    DayWiseCuttingProductionResponseDto create(
            DayWiseCuttingProductionRequestDto request);

    DayWiseCuttingProductionResponseDto getById(Long id);

    List<DayWiseCuttingProductionResponseDto> getAll();

    void delete(Long id);

    CuttingPlanProgressResponseDto getProgress(
            Long cuttingPlanId);


    List<DayWiseCuttingProductionResponseDto> getByCuttingPlan(Long cuttingPlanId);




}


