package com.emranhss.GarmentsManagementSystem.service;

import com.emranhss.GarmentsManagementSystem.dto.request.UomRequestDto;
import com.emranhss.GarmentsManagementSystem.dto.response.UomResponseDto;

import java.util.List;

public interface UomService {
    UomResponseDto save(UomRequestDto dto);

    List<UomResponseDto> findAll();

    UomResponseDto getById(Long id);

    UomResponseDto update(Long id,
                          UomRequestDto dto);

    void delete(Long id);
}
