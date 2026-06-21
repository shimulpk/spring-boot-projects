package com.emranhss.GarmentsManagementSystem.controller;

import com.emranhss.GarmentsManagementSystem.dto.request.RequisitionRequestDto;
import com.emranhss.GarmentsManagementSystem.dto.response.RequisitionResponseDto;
import com.emranhss.GarmentsManagementSystem.service.RequisitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/requisition")
@RequiredArgsConstructor
public class RequisitionController {

    private final RequisitionService requisitionService;
    @PostMapping
    public ResponseEntity<RequisitionResponseDto> create(
            @RequestBody RequisitionRequestDto request) {

        return ResponseEntity.ok(
                requisitionService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RequisitionResponseDto> update(
            @PathVariable Long id,
            @RequestBody RequisitionRequestDto request) {

        return ResponseEntity.ok(
                requisitionService.update(id, request));
    }

    @PutMapping("/{id}/approve")
    public ResponseEntity<RequisitionResponseDto>
    approve(@PathVariable Long id){

        return ResponseEntity.ok(
                requisitionService.approve(id));
    }

    @PutMapping("/{id}/reject")
    public ResponseEntity<RequisitionResponseDto>
    reject(@PathVariable Long id){

        return ResponseEntity.ok(
                requisitionService.reject(id));
    }

    @PutMapping("/{id}/receive")
    public ResponseEntity<RequisitionResponseDto>
    receive(@PathVariable Long id){

        return ResponseEntity.ok(
                requisitionService.receive(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RequisitionResponseDto> getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                requisitionService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @PathVariable Long id) {

        requisitionService.delete(id);

        return ResponseEntity.ok(
                "Requisition Deleted Successfully");
    }
}
