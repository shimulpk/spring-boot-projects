package com.emranhss.GarmentsManagementSystem.controller;

import com.emranhss.GarmentsManagementSystem.dto.request.DayWiseCuttingProductionRequestDto;
import com.emranhss.GarmentsManagementSystem.dto.response.CuttingPlanProgressResponseDto;
import com.emranhss.GarmentsManagementSystem.dto.response.DayWiseCuttingProductionResponseDto;
import com.emranhss.GarmentsManagementSystem.service.DayWiseCuttingProductionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/day-wise-cutting-production")
@RequiredArgsConstructor
public class DayWiseCuttingProductionController {

    private final DayWiseCuttingProductionService service;

    @PostMapping
    public ResponseEntity<DayWiseCuttingProductionResponseDto>  create(
            @RequestBody DayWiseCuttingProductionRequestDto request) {

       return ResponseEntity.ok(service.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DayWiseCuttingProductionResponseDto>  getById(
            @PathVariable Long id) {

       return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<DayWiseCuttingProductionResponseDto>>  getAll() {

        return ResponseEntity.ok(service.getAll());
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id) {

        service.delete(id);
    }

    @GetMapping("/progress/{cuttingPlanId}")
    public ResponseEntity<CuttingPlanProgressResponseDto>  getProgress(
            @PathVariable Long cuttingPlanId) {

        return ResponseEntity.ok(service.getProgress(cuttingPlanId));
    }

    @GetMapping("/cutting-plan/{cuttingPlanId}")
    public ResponseEntity<List<DayWiseCuttingProductionResponseDto>>
    getByCuttingPlan(
            @PathVariable Long cuttingPlanId) {

        return ResponseEntity.ok(
                service.getByCuttingPlan(cuttingPlanId));

    }
}
