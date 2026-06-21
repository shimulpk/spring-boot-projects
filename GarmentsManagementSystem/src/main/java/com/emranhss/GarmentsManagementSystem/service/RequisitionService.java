package com.emranhss.GarmentsManagementSystem.service;

import com.emranhss.GarmentsManagementSystem.dto.request.RequisitionRequestDto;
import com.emranhss.GarmentsManagementSystem.dto.response.RequisitionResponseDto;

import java.util.List;

public interface RequisitionService {
    RequisitionResponseDto create(
            RequisitionRequestDto request);

    RequisitionResponseDto update(
            Long id,
            RequisitionRequestDto request);

    RequisitionResponseDto getById(Long id);

    List<RequisitionResponseDto> getAll();

    void delete(Long id);

    RequisitionResponseDto approve(Long id);

    RequisitionResponseDto reject(Long id);

    RequisitionResponseDto receive(Long id);
}
