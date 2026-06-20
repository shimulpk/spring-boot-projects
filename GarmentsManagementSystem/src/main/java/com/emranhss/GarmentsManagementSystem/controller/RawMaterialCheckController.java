package com.emranhss.GarmentsManagementSystem.controller;

import com.emranhss.GarmentsManagementSystem.dto.request.RawMaterialCheckRequestDto;
import com.emranhss.GarmentsManagementSystem.dto.response.RawMaterialCheckResponseDto;
import com.emranhss.GarmentsManagementSystem.service.RawMaterialCheckService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rmc")
@RequiredArgsConstructor
public class RawMaterialCheckController {

    private final RawMaterialCheckService
            rawMaterialCheckService;

    @PostMapping("/generate")
    public ResponseEntity<
                RawMaterialCheckResponseDto>
    generate(
            @RequestBody
            RawMaterialCheckRequestDto request) {

        return ResponseEntity.ok(
                rawMaterialCheckService
                        .generate(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<
            RawMaterialCheckResponseDto>
    getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                rawMaterialCheckService
                        .getById(id));
    }

    @GetMapping
    public ResponseEntity<
            List<RawMaterialCheckResponseDto>>
    getAll() {

        return ResponseEntity.ok(
                rawMaterialCheckService
                        .getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>
    delete(
            @PathVariable Long id) {

        rawMaterialCheckService.delete(id);

        return ResponseEntity.ok(
                "RMC Deleted Successfully");
    }


}
