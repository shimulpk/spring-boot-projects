package com.emranhss.GarmentsManagementSystem.service;

import com.emranhss.GarmentsManagementSystem.dto.request.VendorRequestDto;
import com.emranhss.GarmentsManagementSystem.dto.response.VendorResponseDto;

import java.util.List;

public interface VendorService {
    
    VendorResponseDto save(VendorRequestDto dto);

    List<VendorResponseDto> findAll();

    VendorResponseDto getById(Long id);

    VendorResponseDto update(Long id,
                             VendorRequestDto dto);

    void delete(Long id);
}
