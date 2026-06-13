package com.emranhss.GarmentsManagementSystem.controller;

import com.emranhss.GarmentsManagementSystem.dto.request.VendorRequestDto;
import com.emranhss.GarmentsManagementSystem.dto.response.VendorResponseDto;
import com.emranhss.GarmentsManagementSystem.entity.Vendor;
import com.emranhss.GarmentsManagementSystem.service.VendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendors")
@RequiredArgsConstructor
public class VendorController {

    private final VendorService vendorService;

    @PostMapping
    public VendorResponseDto save(@RequestBody VendorRequestDto dto){
        return vendorService.save(dto);
    }

    @GetMapping
    public List<VendorResponseDto> findAll(){
        return vendorService.findAll();
    }

    @GetMapping("/{id}")
    public VendorResponseDto getById(@PathVariable Long id){

      return vendorService.getById(id);
    }

    @PutMapping("/{id}")
    public VendorResponseDto update(@PathVariable Long id, @RequestBody VendorRequestDto dto){
        return vendorService.update(id,dto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        vendorService.delete(id);
        return "Vendor Delete Successfully";
    }

}
