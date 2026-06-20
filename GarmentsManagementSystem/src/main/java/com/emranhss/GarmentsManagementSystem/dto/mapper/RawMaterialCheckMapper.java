package com.emranhss.GarmentsManagementSystem.dto.mapper;

import com.emranhss.GarmentsManagementSystem.dto.response.RawMaterialCheckResponseDto;
import com.emranhss.GarmentsManagementSystem.dto.response.RmcDetailResponseDto;
import com.emranhss.GarmentsManagementSystem.entity.RawMaterialCheck;
import com.emranhss.GarmentsManagementSystem.entity.RmcDetail;

import java.util.List;

public class RawMaterialCheckMapper {

    public static RawMaterialCheckResponseDto toDto(
            RawMaterialCheck rmc) {

        if (rmc == null) {
            return null;
        }

        RawMaterialCheckResponseDto dto =
                new RawMaterialCheckResponseDto();

        dto.setId(rmc.getId());

        dto.setCreatedAt(rmc.getCreatedAt());

        dto.setOrderDbId(
                rmc.getOrder().getId());

        dto.setOrderCode(
                rmc.getOrderCode());

        dto.setPoNumber(
                rmc.getPoNumber());

        dto.setTotalFabricRequired(
                rmc.getTotalFabricRequired());

        if (rmc.getStyle() != null) {

            dto.setStyleId(
                    rmc.getStyle().getId());

            dto.setStyleCode(
                    rmc.getStyle().getStyleCode());

            dto.setStyleName(
                    rmc.getStyle().getStyleName());
        }

        List<RmcDetailResponseDto> details =

                rmc.getDetails()
                        .stream()
                        .map(RawMaterialCheckMapper::mapDetail)
                        .toList();

        dto.setDetails(details);

        return dto;
    }

    private static RmcDetailResponseDto mapDetail(
            RmcDetail detail) {

        RmcDetailResponseDto dto =
                new RmcDetailResponseDto();

        dto.setId(detail.getId());
        dto.setProductName(detail.getProductName());
        dto.setSize(detail.getSize());
        dto.setType(detail.getType());
        dto.setBaseFabric(detail.getBaseFabric());
        dto.setQty(detail.getQty());
        dto.setCalculatedFabric(
                detail.getCalculatedFabric());
        dto.setHasUom(detail.getHasUom());

        return dto;
    }
}
