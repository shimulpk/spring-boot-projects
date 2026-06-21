package com.emranhss.GarmentsManagementSystem.service;

import com.emranhss.GarmentsManagementSystem.dto.request.ProcurementPoRequestDto;
import com.emranhss.GarmentsManagementSystem.dto.response.ProcurementPoResponseDto;

import java.util.List;

public interface ProcurementPoService {

    ProcurementPoResponseDto create(
            ProcurementPoRequestDto request);

    ProcurementPoResponseDto update(
            Long id,
            ProcurementPoRequestDto request);

    ProcurementPoResponseDto getById(Long id);

    List<ProcurementPoResponseDto> getAll();

    void delete(Long id);

    ProcurementPoResponseDto issue(Long id);

    ProcurementPoResponseDto receive(Long id);

    ProcurementPoResponseDto cancel(Long id);
}
