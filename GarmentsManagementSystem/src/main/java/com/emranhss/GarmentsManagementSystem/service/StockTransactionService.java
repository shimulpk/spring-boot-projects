package com.emranhss.GarmentsManagementSystem.service;


import com.emranhss.GarmentsManagementSystem.dto.request.StockTransactionRequestDto;
import com.emranhss.GarmentsManagementSystem.dto.response.StockTransactionResponseDto;

import java.util.List;

public interface StockTransactionService {

    StockTransactionResponseDto create(StockTransactionRequestDto requestDto);

    StockTransactionResponseDto getById(Long id);
    

    List<StockTransactionResponseDto> getAll();

    List<StockTransactionResponseDto> getByInventory(Long inventoryId);

    void delete(Long id);
}
