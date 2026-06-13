package com.emranhss.GarmentsManagementSystem.serviceimp;

import com.emranhss.GarmentsManagementSystem.dto.mapper.VendorMapper;
import com.emranhss.GarmentsManagementSystem.dto.request.VendorRequestDto;
import com.emranhss.GarmentsManagementSystem.dto.response.VendorResponseDto;
import com.emranhss.GarmentsManagementSystem.entity.Vendor;
import com.emranhss.GarmentsManagementSystem.repository.VendorRepository;
import com.emranhss.GarmentsManagementSystem.service.VendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VendorServiceImp implements VendorService {
    private final VendorRepository vendorRepository;

    @Override
    public VendorResponseDto save(VendorRequestDto dto) {

        Vendor vendor= VendorMapper.toEntity(dto);
        Vendor saved = vendorRepository.save(vendor);
        return VendorMapper.toDto(saved);

    }

    @Override
    public List<VendorResponseDto> findAll() {

        return vendorRepository.findAll()
                .stream().map(VendorMapper::toDto).toList();

    }

    @Override
    public VendorResponseDto getById(Long id) {
        Vendor vendor=vendorRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Vendor not Found"));
        return VendorMapper.toDto(vendor);

    }

    @Override
    public VendorResponseDto update(Long id, VendorRequestDto dto) {
        Vendor vendor=vendorRepository.findById(id).orElseThrow(()->new RuntimeException("Vendor not found"));

        vendor.setCompanyName(dto.getCompanyName());
        vendor.setContactPerson(dto.getContactPerson());
        vendor.setPhone(dto.getPhone());
        vendor.setAddress(dto.getAddress());
        Vendor updated= vendorRepository.save(vendor);

        return VendorMapper.toDto(updated);
    }

    @Override
    public void delete(Long id) {
        vendorRepository.deleteById(id);

    }
}
