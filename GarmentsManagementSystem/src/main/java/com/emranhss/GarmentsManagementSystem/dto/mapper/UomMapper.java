package com.emranhss.GarmentsManagementSystem.dto.mapper;

import com.emranhss.GarmentsManagementSystem.dto.request.UomRequestDto;
import com.emranhss.GarmentsManagementSystem.dto.response.UomResponseDto;
import com.emranhss.GarmentsManagementSystem.entity.Uom;

public class UomMapper {
    public static Uom toEntity(UomRequestDto dto){

        if(dto == null){
            return null;
        }

        Uom uom = new Uom();

        uom.setName(dto.getName());
        uom.setShortName(dto.getShortName());

        return uom;
    }

    public static UomResponseDto toDto(Uom uom){

        if(uom == null){
            return null;
        }

        UomResponseDto dto = new UomResponseDto();

        dto.setId(uom.getId());
        dto.setName(uom.getName());
        dto.setShortName(uom.getShortName());

        return dto;
    }
}
