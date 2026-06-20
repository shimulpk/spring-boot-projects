package com.emranhss.GarmentsManagementSystem.service;

import com.emranhss.GarmentsManagementSystem.dto.request.RawMaterialCheckRequestDto;
import com.emranhss.GarmentsManagementSystem.dto.response.RawMaterialCheckResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RawMaterialCheckService {
    RawMaterialCheckResponseDto generate(
            RawMaterialCheckRequestDto request);

    RawMaterialCheckResponseDto getById(Long id);

    List<RawMaterialCheckResponseDto> getAll();

    void delete(Long id);
}
