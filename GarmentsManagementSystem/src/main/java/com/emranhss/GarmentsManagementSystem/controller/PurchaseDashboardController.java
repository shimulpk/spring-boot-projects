package com.emranhss.GarmentsManagementSystem.controller;

import com.emranhss.GarmentsManagementSystem.dto.response.PurchaseDashboardResponseDto;
import com.emranhss.GarmentsManagementSystem.service.PurchaseDashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard/purchase")
@RequiredArgsConstructor
public class PurchaseDashboardController {

    private final PurchaseDashboardService purchaseDashboardService;

    @GetMapping
    public ResponseEntity<PurchaseDashboardResponseDto> getDashboard() {

        return ResponseEntity.ok(
                purchaseDashboardService.getDashboard()
        );

    }

}
