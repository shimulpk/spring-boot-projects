package com.emranhss.GarmentsManagementSystem.controller;

import com.emranhss.GarmentsManagementSystem.dto.request.DayWisePackingProductionRequestDto;
import com.emranhss.GarmentsManagementSystem.dto.response.DayWisePackingProductionResponseDto;
import com.emranhss.GarmentsManagementSystem.dto.response.PackingPlanProgressResponseDto;
import com.emranhss.GarmentsManagementSystem.service.DayWisePackingProductionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/day-wise-packing-productions")
@RequiredArgsConstructor
public class DayWisePackingProductionController {

    private final DayWisePackingProductionService dayWisePackingProductionService;

    @PostMapping
    public ResponseEntity<DayWisePackingProductionResponseDto> create(
            @RequestBody DayWisePackingProductionRequestDto request) {

        return ResponseEntity.ok(
                dayWisePackingProductionService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DayWisePackingProductionResponseDto> update(
            @PathVariable Long id,
            @RequestBody DayWisePackingProductionRequestDto request) {

        return ResponseEntity.ok(
                dayWisePackingProductionService.update(id, request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DayWisePackingProductionResponseDto> getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                dayWisePackingProductionService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<DayWisePackingProductionResponseDto>> getAll() {

        return ResponseEntity.ok(
                dayWisePackingProductionService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @PathVariable Long id) {

        dayWisePackingProductionService.delete(id);

        return ResponseEntity.ok(
                "Day Wise Packing Production Deleted Successfully");
    }

//    Angular Summary Card Plan Input, Packed So Far, Remaining

    @GetMapping("/progress")
    public ResponseEntity<PackingPlanProgressResponseDto> getProgress(
            @RequestParam Long packingPlanId) {

        return ResponseEntity.ok(
                dayWisePackingProductionService.getProgress(
                        packingPlanId));
    }

    @GetMapping("/packing-plan/{packingPlanId}")
    public ResponseEntity<List<DayWisePackingProductionResponseDto>>
    getByPackingPlan(
            @PathVariable Long packingPlanId) {

        return ResponseEntity.ok(
                dayWisePackingProductionService
                        .getByPackingPlan(
                                packingPlanId));

    }
}
