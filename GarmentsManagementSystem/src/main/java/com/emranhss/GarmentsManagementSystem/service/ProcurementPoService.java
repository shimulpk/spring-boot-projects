package com.emranhss.GarmentsManagementSystem.service;

import com.emranhss.GarmentsManagementSystem.dto.request.ProcurementPoRequestDto;
import com.emranhss.GarmentsManagementSystem.dto.response.ProcurementPoResponseDto;

import java.util.List;

public interface ProcurementPoService {

    // ===========================
    // Create Purchase Order
    // ===========================

    ProcurementPoResponseDto create(
            ProcurementPoRequestDto request);

    // ===========================
    // Update Purchase Order
    // ===========================

    ProcurementPoResponseDto update(
            Long id,
            ProcurementPoRequestDto request);

    // ===========================
    // Get Purchase Order By Id
    // ===========================

    ProcurementPoResponseDto getById(
            Long id);

    // ===========================
    // Get All Purchase Orders
    // ===========================

    List<ProcurementPoResponseDto> getAll();

    // ===========================
    // Delete Purchase Order
    // ===========================

    void delete(Long id);

    // ===========================
    // Issue Purchase Order
    // ===========================

    ProcurementPoResponseDto issue(
            Long id);

    // ===========================
    // Receive Purchase Order
    // ===========================

    ProcurementPoResponseDto receive(
            Long id);

    // ===========================
    // Cancel Purchase Order
    // ===========================

    ProcurementPoResponseDto cancel(
            Long id);
}
