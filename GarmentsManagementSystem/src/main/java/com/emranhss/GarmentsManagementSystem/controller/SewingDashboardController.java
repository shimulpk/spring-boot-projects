package com.emranhss.GarmentsManagementSystem.controller;

import com.emranhss.GarmentsManagementSystem.dto.response.SewingDashboardResponseDto;
import com.emranhss.GarmentsManagementSystem.service.SewingDashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard/sewing")
@RequiredArgsConstructor
public class SewingDashboardController {

    private final SewingDashboardService sewingDashboardService;

    @GetMapping
    public ResponseEntity<SewingDashboardResponseDto> getDashboard() {

        return ResponseEntity.ok(
                sewingDashboardService.getDashboard()
        );

    }
}
