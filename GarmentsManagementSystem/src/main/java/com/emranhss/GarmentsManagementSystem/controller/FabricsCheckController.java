package com.emranhss.GarmentsManagementSystem.controller;

import com.emranhss.GarmentsManagementSystem.dto.request.FabricsCheckRequestDto;
import com.emranhss.GarmentsManagementSystem.dto.response.FabricsCheckResponseDto;
import com.emranhss.GarmentsManagementSystem.service.FabricsCheckService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rmc")
@RequiredArgsConstructor
public class FabricsCheckController {

    private final FabricsCheckService
            rawMaterialCheckService;

    @PostMapping("/generate")
    public ResponseEntity<
            FabricsCheckResponseDto>
    generate(
            @RequestBody
            FabricsCheckRequestDto request) {

        return ResponseEntity.ok(
                rawMaterialCheckService
                        .generate(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<
            FabricsCheckResponseDto>
    getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                rawMaterialCheckService
                        .getById(id));
    }

    @GetMapping
    public ResponseEntity<
            List<FabricsCheckResponseDto>>
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
