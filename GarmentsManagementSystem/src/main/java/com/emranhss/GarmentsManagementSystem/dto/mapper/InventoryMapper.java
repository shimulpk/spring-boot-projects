package com.emranhss.GarmentsManagementSystem.dto.mapper;

import com.emranhss.GarmentsManagementSystem.dto.response.InventoryResponseDto;
import com.emranhss.GarmentsManagementSystem.entity.Inventory;

public class InventoryMapper {

    public static InventoryResponseDto toDto(
            Inventory inventory) {

        if (inventory == null) {
            return null;
        }

        InventoryResponseDto dto =
                new InventoryResponseDto();

        dto.setId(inventory.getId());

        dto.setQuantity(
                inventory.getQuantity());

        dto.setItemName(
                inventory.getItemName());

        dto.setCategory(
                inventory.getCategory());

        dto.setUnit(
                inventory.getUnit());

        if (inventory.getItem() != null) {

            dto.setItemId(
                    inventory.getItem().getId());
        }

        return dto;
    }
}
