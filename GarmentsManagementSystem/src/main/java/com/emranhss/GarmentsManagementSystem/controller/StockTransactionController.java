package com.emranhss.GarmentsManagementSystem.controller;

import com.emranhss.GarmentsManagementSystem.dto.request.StockTransactionRequestDto;
import com.emranhss.GarmentsManagementSystem.dto.response.StockTransactionResponseDto;
import com.emranhss.GarmentsManagementSystem.entity.StockTransaction;
import com.emranhss.GarmentsManagementSystem.service.StockTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stock-transactions")
@RequiredArgsConstructor
public class StockTransactionController {

    private final StockTransactionService stockTransactionService;

    @PostMapping
    public ResponseEntity<StockTransactionResponseDto> create(@RequestBody StockTransactionRequestDto requestDto){
        return ResponseEntity.ok(stockTransactionService.create(requestDto));
    }

@GetMapping("/{id}")
    public ResponseEntity<StockTransactionResponseDto> getById(@PathVariable Long id){

        return ResponseEntity.ok(stockTransactionService.getById(id));
}

@GetMapping
    public ResponseEntity<List<StockTransactionResponseDto>> getAll(){
       return ResponseEntity.ok(stockTransactionService.getAll());
}

@GetMapping("/inventory/{inventoryId}")
    public ResponseEntity<List<StockTransactionResponseDto>> getByInventory(@PathVariable Long inventoryId){

        return ResponseEntity.ok(stockTransactionService.getByInventory(inventoryId));
}
@DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        stockTransactionService.delete(id);
    return ResponseEntity.ok("Delete Successfully");
}
}
