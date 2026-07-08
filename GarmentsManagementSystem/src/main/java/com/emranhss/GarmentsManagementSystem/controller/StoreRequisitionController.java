package com.emranhss.GarmentsManagementSystem.controller;

import com.emranhss.GarmentsManagementSystem.dto.request.StoreRequisitionRequestDto;
import com.emranhss.GarmentsManagementSystem.dto.response.StoreRequisitionResponseDto;
import com.emranhss.GarmentsManagementSystem.service.StoreRequisitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/store-requisitions")
@RequiredArgsConstructor
public class StoreRequisitionController {

    private final StoreRequisitionService storeRequisitionService;

    @PostMapping
    public ResponseEntity<StoreRequisitionResponseDto> create(
            @RequestBody StoreRequisitionRequestDto request) {

        return ResponseEntity.ok(
                storeRequisitionService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StoreRequisitionResponseDto> update(
            @PathVariable Long id,
            @RequestBody StoreRequisitionRequestDto request) {

        return ResponseEntity.ok(
                storeRequisitionService.update(id, request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StoreRequisitionResponseDto> getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                storeRequisitionService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<StoreRequisitionResponseDto>> getAll() {

        return ResponseEntity.ok(
                storeRequisitionService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @PathVariable Long id) {

        storeRequisitionService.delete(id);

        return ResponseEntity.ok(
                "Purchase Requisition Deleted Successfully");
    }
}
