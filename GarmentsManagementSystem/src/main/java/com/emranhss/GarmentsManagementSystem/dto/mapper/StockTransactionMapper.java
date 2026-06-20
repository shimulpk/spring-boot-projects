package com.emranhss.GarmentsManagementSystem.dto.mapper;

import com.emranhss.GarmentsManagementSystem.dto.response.StockTransactionResponseDto;
import com.emranhss.GarmentsManagementSystem.entity.StockTransaction;

public class StockTransactionMapper {
    public static StockTransactionResponseDto toDto(
            StockTransaction transaction) {

        if (transaction == null) {
            return null;
        }

        StockTransactionResponseDto dto =
                new StockTransactionResponseDto();

        dto.setId(transaction.getId());

        dto.setItemName(
                transaction.getItemName());

        dto.setTransactionType(
                transaction.getTransactionType());

        dto.setQuantity(
                transaction.getQuantity());

        dto.setTransactionDate(
                transaction.getTransactionDate());

        dto.setCreatedAt(
                transaction.getCreatedAt());

        if (transaction.getInventory() != null) {

            dto.setInventoryId(
                    transaction.getInventory().getId());
        }

        return dto;
    }
}
