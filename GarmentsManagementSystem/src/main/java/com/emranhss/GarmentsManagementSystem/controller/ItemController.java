package com.emranhss.GarmentsManagementSystem.controller;

import com.emranhss.GarmentsManagementSystem.dto.request.ItemRequestDto;
import com.emranhss.GarmentsManagementSystem.dto.response.ItemResponseDto;
import com.emranhss.GarmentsManagementSystem.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping
    public ItemResponseDto save(
            @RequestBody ItemRequestDto dto){

        return itemService.save(dto);
    }

    @GetMapping
    public List<ItemResponseDto> findAll(){

        return itemService.findAll();
    }

    @GetMapping("/{id}")
    public ItemResponseDto getById(
            @PathVariable Long id){

        return itemService.getById(id);
    }

    @PutMapping("/{id}")
    public ItemResponseDto update(
            @PathVariable Long id,
            @RequestBody ItemRequestDto dto){

        return itemService.update(id,dto);
    }

    @DeleteMapping("/{id}")
    public String delete(
            @PathVariable Long id){

        itemService.delete(id);

        return "Item Deleted Successfully";
    }
}
