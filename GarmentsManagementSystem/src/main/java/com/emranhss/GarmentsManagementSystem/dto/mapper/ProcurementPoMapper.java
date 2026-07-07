package com.emranhss.GarmentsManagementSystem.dto.mapper;

import com.emranhss.GarmentsManagementSystem.dto.request.ProcurementPoItemRequestDto;
import com.emranhss.GarmentsManagementSystem.dto.request.ProcurementPoRequestDto;
import com.emranhss.GarmentsManagementSystem.dto.response.ProcurementPoItemResponseDto;
import com.emranhss.GarmentsManagementSystem.dto.response.ProcurementPoResponseDto;
import com.emranhss.GarmentsManagementSystem.entity.ProcurementPo;
import com.emranhss.GarmentsManagementSystem.entity.ProcurementPoItem;
import com.emranhss.GarmentsManagementSystem.entity.Requisition;

import java.util.stream.Collectors;

public class ProcurementPoMapper {

    // ===========================
    // Entity -> Response DTO
    // ===========================

    public static ProcurementPoResponseDto toDto(
            ProcurementPo po) {

        ProcurementPoResponseDto dto =
                new ProcurementPoResponseDto();

        dto.setId(po.getId());

        dto.setPoNumber(po.getPoNumber());

        dto.setPoDate(po.getPoDate());

        dto.setDeliveryDate(po.getDeliveryDate());

        dto.setVendorId(po.getVendor().getId());

        dto.setVendorName(
                po.getVendor().getCompanyName());

        dto.setRequisitionId(
                po.getRequisition().getId());

        dto.setTaxPercent(
                po.getTaxPercent());

        dto.setSubTotal(
                po.getSubTotal());

        dto.setTaxAmount(
                po.getTaxAmount());

        dto.setGrandTotal(
                po.getGrandTotal());

        dto.setStatus(
                po.getStatus());

        dto.setItems(
                po.getItems()
                        .stream()

                        .map(item -> ProcurementPoMapper.toItemDto(item))
                        .collect(Collectors.toList())
        );

        return dto;

    }

    // ===========================
    // Item Entity -> Item DTO
    // ===========================

    public static ProcurementPoItemResponseDto toItemDto(
            ProcurementPoItem item) {

        ProcurementPoItemResponseDto dto =
                new ProcurementPoItemResponseDto();

        dto.setId(item.getId());

        dto.setMaterialName(
                item.getMaterialName());

        dto.setUnit(
                item.getUnit());

        dto.setQuantity(
                item.getQuantity());

        dto.setUnitPrice(
                item.getUnitPrice());

        dto.setLineTotal(
                item.getLineTotal());

        return dto;

    }

    // ===========================
    // Request -> Entity
    // ===========================

    public static ProcurementPo toEntity(
            ProcurementPoRequestDto request) {

        ProcurementPo po =
                new ProcurementPo();

        po.setPoNumber(
                request.getPoNumber());

        po.setPoDate(
                request.getPoDate());

        po.setDeliveryDate(
                request.getDeliveryDate());

        po.setTaxPercent(
                request.getTaxPercent());

        return po;

    }

    // ===========================
    // Item Request -> Entity
    // ===========================

    public static ProcurementPoItem toItemEntity(
            ProcurementPoItemRequestDto request) {

        ProcurementPoItem item =
                new ProcurementPoItem();

        item.setMaterialName(
                request.getMaterialName());

        item.setUnit(
                request.getUnit());

        item.setQuantity(
                request.getQuantity());

        item.setUnitPrice(
                request.getUnitPrice());

        return item;

    }
}
