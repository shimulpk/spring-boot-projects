package com.emranhss.GarmentsManagementSystem.serviceimp;

import com.emranhss.GarmentsManagementSystem.dto.mapper.InventoryMapper;
import com.emranhss.GarmentsManagementSystem.dto.request.InventoryRequestDto;
import com.emranhss.GarmentsManagementSystem.dto.response.InventoryResponseDto;
import com.emranhss.GarmentsManagementSystem.entity.Inventory;
import com.emranhss.GarmentsManagementSystem.entity.Item;
import com.emranhss.GarmentsManagementSystem.repository.InventoryRepository;
import com.emranhss.GarmentsManagementSystem.repository.ItemRepository;
import com.emranhss.GarmentsManagementSystem.service.InventoryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;
    private final ItemRepository itemRepository;


    @Override
    public InventoryResponseDto create(InventoryRequestDto request) {
        Item item = itemRepository.findById(request.getItemId())
                .orElseThrow(()-> new RuntimeException("Item not found"));

        Inventory inventory = new Inventory();

        inventory.setItem(item);

        inventory.setItemName(item.getItemName());
        inventory.setCategory(item.getCategory());
        inventory.setUnit(item.getUnit());
        inventory.setQuantity(request.getQuantity());

        Inventory savedInventory = inventoryRepository.save(inventory);
        return InventoryMapper.toDto(savedInventory);

    }

    @Override
    public InventoryResponseDto update(Long id, InventoryRequestDto request) {
       Inventory inventory = inventoryRepository
               .findById(id).orElseThrow(()->
                       new RuntimeException("Inventory not found"));

       Item item = itemRepository.findById(request.getItemId())
               .orElseThrow(()-> new RuntimeException("item not found"));

       inventory.setItem(item);
       inventory.setItemName(item.getItemName());
       inventory.setCategory(item.getCategory());
       inventory.setUnit(item.getUnit());
       inventory.setQuantity(request.getQuantity());

       Inventory updateInventory = inventoryRepository.save(inventory);
       return InventoryMapper.toDto(updateInventory);

    }

    @Override
    public InventoryResponseDto getById(Long id) {
        Inventory inventory = inventoryRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Inventory not found"));

        return InventoryMapper.toDto(inventory);
    }

    @Override
    public List<InventoryResponseDto> getAll() {
        return inventoryRepository.findAll()
                .stream().map(InventoryMapper::toDto).toList();
    }

    @Override
    public void delete(Long id) {
    Inventory inventory = inventoryRepository.findById(id)
            .orElseThrow(()-> new RuntimeException("Inventory not found"));
    inventoryRepository.delete(inventory);


    }
}
