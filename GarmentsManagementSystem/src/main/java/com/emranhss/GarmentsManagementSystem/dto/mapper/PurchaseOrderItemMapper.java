package com.emranhss.GarmentsManagementSystem.dto.mapper;

import com.emranhss.GarmentsManagementSystem.dto.response.PurchaseOrderItemResponseDto;
import com.emranhss.GarmentsManagementSystem.entity.PurchaseOrderItem;

public class PurchaseOrderItemMapper {

    public static PurchaseOrderItemResponseDto toDto(
            PurchaseOrderItem item) {

        if (item == null) {
            return null;
        }

        PurchaseOrderItemResponseDto dto =
                new PurchaseOrderItemResponseDto();

        dto.setId(item.getId());

        dto.setItemId(
                item.getItem().getId());

        dto.setItemName(
                item.getItem().getItemName());

        dto.setUnit(
                item.getItem().getUnit());

        dto.setQuantity(
                item.getQuantity());

        dto.setUnitPrice(
                item.getUnitPrice());

        dto.setTotalPrice(
                item.getQuantity() * item.getUnitPrice());

        dto.setRemarks(
                item.getRemarks());

        return dto;
    }
}
