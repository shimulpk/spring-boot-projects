package com.emranhss.GarmentsManagementSystem.controller;

import com.emranhss.GarmentsManagementSystem.dto.request.UomRequestDto;
import com.emranhss.GarmentsManagementSystem.dto.response.UomResponseDto;
import com.emranhss.GarmentsManagementSystem.service.UomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/uoms")
@RequiredArgsConstructor

public class UomController {
    private final UomService uomService;

    @PostMapping
    public UomResponseDto save(
            @RequestBody UomRequestDto dto){

        return uomService.save(dto);
    }

    @GetMapping
    public List<UomResponseDto> findAll(){

        return uomService.findAll();
    }

    @GetMapping("/{id}")
    public UomResponseDto getById(
            @PathVariable Long id){

        return uomService.getById(id);
    }

    @PutMapping("/{id}")
    public UomResponseDto update(
            @PathVariable Long id,
            @RequestBody UomRequestDto dto){

        return uomService.update(id,dto);
    }

    @DeleteMapping("/{id}")
    public String delete(
            @PathVariable Long id){

        uomService.delete(id);

        return "UOM Deleted Successfully";
    }
}
