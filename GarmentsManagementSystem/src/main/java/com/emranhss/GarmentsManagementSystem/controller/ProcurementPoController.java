package com.emranhss.GarmentsManagementSystem.controller;

import com.emranhss.GarmentsManagementSystem.dto.request.ProcurementPoRequestDto;
import com.emranhss.GarmentsManagementSystem.dto.response.ProcurementPoResponseDto;
import com.emranhss.GarmentsManagementSystem.service.ProcurementPoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/procurement-pos")
@RequiredArgsConstructor
public class ProcurementPoController {

    private final ProcurementPoService procurementPoService;

    @PostMapping
    public ResponseEntity<ProcurementPoResponseDto> create(
            @RequestBody ProcurementPoRequestDto request) {

        return ResponseEntity.ok(
                procurementPoService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProcurementPoResponseDto> update(
            @PathVariable Long id,
            @RequestBody ProcurementPoRequestDto request) {

        return ResponseEntity.ok(
                procurementPoService.update(id, request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProcurementPoResponseDto> getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                procurementPoService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProcurementPoResponseDto>> getAll() {

        return ResponseEntity.ok(
                procurementPoService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @PathVariable Long id) {

        procurementPoService.delete(id);

        return ResponseEntity.ok("Deleted Successfully");
    }

    @PutMapping("/{id}/issue")
    public ResponseEntity<ProcurementPoResponseDto> issue(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                procurementPoService.issue(id));
    }

    @PutMapping("/{id}/receive")
    public ResponseEntity<ProcurementPoResponseDto> receive(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                procurementPoService.receive(id));
    }

    @PutMapping("/{id}/cancel")
    public ResponseEntity<ProcurementPoResponseDto> cancel(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                procurementPoService.cancel(id));
    }
}
