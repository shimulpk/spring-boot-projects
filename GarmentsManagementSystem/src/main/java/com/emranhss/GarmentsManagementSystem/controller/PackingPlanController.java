package com.emranhss.GarmentsManagementSystem.controller;

import com.emranhss.GarmentsManagementSystem.dto.request.PackingPlanRequestDto;
import com.emranhss.GarmentsManagementSystem.dto.response.PackingPlanResponseDto;
import com.emranhss.GarmentsManagementSystem.service.PackingPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/packing-plans")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('ADMIN','PACKING_MANAGER','PRODUCTION_MANAGER')")
public class PackingPlanController {

    private final PackingPlanService packingPlanService;


    @PostMapping
    public ResponseEntity<PackingPlanResponseDto> create(
            @RequestBody PackingPlanRequestDto request) {

        return ResponseEntity.ok(
                packingPlanService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PackingPlanResponseDto> update(
            @PathVariable Long id,
            @RequestBody PackingPlanRequestDto request) {

        return ResponseEntity.ok(
                packingPlanService.update(id, request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PackingPlanResponseDto> getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                packingPlanService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<PackingPlanResponseDto>> getAll() {

        return ResponseEntity.ok(
                packingPlanService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @PathVariable Long id) {

        packingPlanService.delete(id);

        return ResponseEntity.ok(
                "Packing Plan Deleted Successfully");
    }
}
