package com.emranhss.GarmentsManagementSystem.serviceimp;

import com.emranhss.GarmentsManagementSystem.dto.mapper.UomMapper;
import com.emranhss.GarmentsManagementSystem.dto.request.UomRequestDto;
import com.emranhss.GarmentsManagementSystem.dto.response.UomResponseDto;
import com.emranhss.GarmentsManagementSystem.entity.Uom;
import com.emranhss.GarmentsManagementSystem.repository.UomRepository;
import com.emranhss.GarmentsManagementSystem.service.UomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UomServiceImp implements UomService {
    private final UomRepository uomRepository;


    @Override
    public UomResponseDto save(UomRequestDto dto) {
        Uom uom = UomMapper.toEntity(dto);

        Uom saved =
                uomRepository.save(uom);

        return UomMapper.toDto(saved);
    }

    @Override
    public List<UomResponseDto> findAll() {
        return uomRepository.findAll()
                .stream()
                .map(UomMapper::toDto)
                .toList();
    }

    @Override
    public UomResponseDto getById(Long id) {
        Uom uom =
                uomRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("UOM Not Found"));

        return UomMapper.toDto(uom);
    }

    @Override
    public UomResponseDto update(Long id, UomRequestDto dto) {
        Uom uom =
                uomRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("UOM Not Found"));

        uom.setName(dto.getName());
        uom.setShortName(dto.getShortName());

        Uom updated =
                uomRepository.save(uom);

        return UomMapper.toDto(updated);
    }

    @Override
    public void delete(Long id) {
        uomRepository.deleteById(id);

    }
}
