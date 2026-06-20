package com.emranhss.GarmentsManagementSystem.serviceimp;

import com.emranhss.GarmentsManagementSystem.dto.mapper.StockTransactionMapper;
import com.emranhss.GarmentsManagementSystem.dto.request.StockTransactionRequestDto;
import com.emranhss.GarmentsManagementSystem.dto.response.StockTransactionResponseDto;
import com.emranhss.GarmentsManagementSystem.entity.Inventory;
import com.emranhss.GarmentsManagementSystem.entity.StockTransaction;
import com.emranhss.GarmentsManagementSystem.enums.TransactionType;
import com.emranhss.GarmentsManagementSystem.repository.InventoryRepository;
import com.emranhss.GarmentsManagementSystem.repository.StockTransactionRepository;
import com.emranhss.GarmentsManagementSystem.service.StockTransactionService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class StockTransactionServiceImpl implements StockTransactionService {

    private final StockTransactionRepository stockTransactionRepository;
    private final InventoryRepository inventoryRepository;


    @Override
    public StockTransactionResponseDto create(StockTransactionRequestDto requestDto) {
        Inventory inventory = inventoryRepository
                .findById(requestDto.getInventoryId())
                .orElseThrow(()-> new RuntimeException("Inventory not Found"));

        BigDecimal currentQty = inventory.getQuantity();
        BigDecimal txnQty = requestDto.getQuantity();

        if(requestDto.getTransactionType() == TransactionType.IN){

            inventory.setQuantity(currentQty.add(txnQty));
        }

        else {
            if(currentQty.compareTo(txnQty) < 0){
                throw new RuntimeException("Insufficient Stock");
            }

            inventory.setQuantity(currentQty.subtract(txnQty));

        }
        inventoryRepository.save(inventory);

        StockTransaction stockTransaction = new StockTransaction();

        stockTransaction.setInventory(inventory);
        stockTransaction.setItemName(inventory.getItemName());
        stockTransaction.setTransactionType(requestDto.getTransactionType());
        stockTransaction.setQuantity(requestDto.getQuantity());
        stockTransaction.setTransactionDate(requestDto.getTransactionDate());

        StockTransaction savedTransaction = stockTransactionRepository.save(stockTransaction);
        return StockTransactionMapper.toDto(savedTransaction);

    }

    @Override
    public StockTransactionResponseDto getById(Long id) {
        return stockTransactionRepository
                .findById(id).map(StockTransactionMapper::toDto)
                .orElseThrow(()-> new RuntimeException("Transaction not found"));


    }

    @Override
    public List<StockTransactionResponseDto> getAll() {
        return stockTransactionRepository
                .findAll().stream().map(StockTransactionMapper::toDto).toList();
    }

    @Override
    public List<StockTransactionResponseDto> getByInventory(Long inventoryId) {
        return stockTransactionRepository
                .findByInventory_Id(inventoryId)
                .stream().map(StockTransactionMapper::toDto).toList();
    }

    @Override
    public void delete(Long id) {
    StockTransaction stockTransaction = stockTransactionRepository
            .findById(id).orElseThrow(()->
                    new RuntimeException("Transaction not Found"));

    stockTransactionRepository.delete(stockTransaction);


    }
}
