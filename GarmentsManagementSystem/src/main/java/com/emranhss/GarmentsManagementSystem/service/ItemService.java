package com.emranhss.GarmentsManagementSystem.service;

import com.emranhss.GarmentsManagementSystem.dto.request.ItemRequestDto;
import com.emranhss.GarmentsManagementSystem.dto.response.ItemResponseDto;

import java.util.List;

public interface ItemService {
    ItemResponseDto save(ItemRequestDto dto);

    List<ItemResponseDto> findAll();

    ItemResponseDto getById(Long id);

    ItemResponseDto update(Long id,
                           ItemRequestDto dto);

    void delete(Long id);
}
