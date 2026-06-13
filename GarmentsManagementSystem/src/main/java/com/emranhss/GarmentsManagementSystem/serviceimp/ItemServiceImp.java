package com.emranhss.GarmentsManagementSystem.serviceimp;

import com.emranhss.GarmentsManagementSystem.dto.mapper.ItemMapper;
import com.emranhss.GarmentsManagementSystem.dto.request.ItemRequestDto;
import com.emranhss.GarmentsManagementSystem.dto.response.ItemResponseDto;
import com.emranhss.GarmentsManagementSystem.entity.Item;
import com.emranhss.GarmentsManagementSystem.entity.Uom;
import com.emranhss.GarmentsManagementSystem.repository.ItemRepository;
import com.emranhss.GarmentsManagementSystem.repository.UomRepository;
import com.emranhss.GarmentsManagementSystem.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImp implements ItemService {

    private final ItemRepository itemRepository;
    private final UomRepository uomRepository;

    @Override
    public ItemResponseDto save(ItemRequestDto dto) {
        Item item = ItemMapper.toEntity(dto);

        Uom uom = uomRepository.findById(dto.getUomId())
                .orElseThrow(() ->
                        new RuntimeException("UOM Not Found"));

        item.setUom(uom);

        Item saved = itemRepository.save(item);

        return ItemMapper.toDto(saved);
    }

    @Override
    public List<ItemResponseDto> findAll() {
        return itemRepository.findAll()
                .stream()
                .map(ItemMapper::toDto)
                .toList();
    }

    @Override
    public ItemResponseDto getById(Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Item Not Found"));

        return ItemMapper.toDto(item);
    }

    @Override
    public ItemResponseDto update(Long id, ItemRequestDto dto) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Item Not Found"));

        Uom uom = uomRepository.findById(dto.getUomId())
                .orElseThrow(() ->
                        new RuntimeException("UOM Not Found"));

        item.setItemCode(dto.getItemCode());
        item.setItemName(dto.getItemName());
        item.setDescription(dto.getDescription());
        item.setUom(uom);

        Item updated = itemRepository.save(item);

        return ItemMapper.toDto(updated);
    }

    @Override
    public void delete(Long id) {
        itemRepository.deleteById(id);
    }
}
