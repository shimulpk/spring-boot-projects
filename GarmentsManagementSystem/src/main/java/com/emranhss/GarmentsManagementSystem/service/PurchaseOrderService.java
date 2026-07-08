package com.emranhss.GarmentsManagementSystem.service;

import com.emranhss.GarmentsManagementSystem.dto.request.PurchaseOrderRequestDto;
import com.emranhss.GarmentsManagementSystem.dto.response.PurchaseOrderItemResponseDto;
import com.emranhss.GarmentsManagementSystem.dto.response.PurchaseOrderResponseDto;

import java.util.List;

public interface PurchaseOrderService {

    PurchaseOrderResponseDto create(
            PurchaseOrderRequestDto request);

    PurchaseOrderResponseDto update(
            Long id,
            PurchaseOrderRequestDto request);

    PurchaseOrderResponseDto getById(Long id);

    List<PurchaseOrderResponseDto> getAll();

    void delete(Long id);

}
