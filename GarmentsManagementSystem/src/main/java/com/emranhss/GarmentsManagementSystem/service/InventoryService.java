package com.emranhss.GarmentsManagementSystem.service;


import com.emranhss.GarmentsManagementSystem.dto.request.InventoryRequestDto;
import com.emranhss.GarmentsManagementSystem.dto.response.InventoryResponseDto;

import java.util.List;

public interface InventoryService {

    InventoryResponseDto create(InventoryRequestDto request);

    InventoryResponseDto update( Long id, InventoryRequestDto request);

    InventoryResponseDto getById( Long id);

    List<InventoryResponseDto> getAll();

    void delete(Long id);
}
