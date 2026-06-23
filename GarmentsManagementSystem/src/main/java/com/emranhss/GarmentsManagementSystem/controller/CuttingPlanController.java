package com.emranhss.GarmentsManagementSystem.controller;

import com.emranhss.GarmentsManagementSystem.dto.request.CuttingPlanRequestDto;
import com.emranhss.GarmentsManagementSystem.dto.response.CuttingPlanResponseDto;
import com.emranhss.GarmentsManagementSystem.service.CuttingPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cutting-plans")
@RequiredArgsConstructor
public class CuttingPlanController {

    private final CuttingPlanService cuttingPlanService;

    @PostMapping
    public ResponseEntity<CuttingPlanResponseDto>
    create(@RequestBody CuttingPlanRequestDto requestDto) {
        return ResponseEntity.ok(cuttingPlanService.create(requestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CuttingPlanResponseDto>
    update(@PathVariable Long id, @RequestBody CuttingPlanRequestDto requestDto) {
        return ResponseEntity.ok(cuttingPlanService.update(id, requestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CuttingPlanResponseDto>  getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(cuttingPlanService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<CuttingPlanResponseDto>> getAll(){
        return ResponseEntity.ok(cuttingPlanService.getAll());
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id) {

        cuttingPlanService.delete(id);
    }
}
