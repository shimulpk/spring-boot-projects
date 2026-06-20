package com.emranhss.GarmentsManagementSystem.controller;

import com.emranhss.GarmentsManagementSystem.dto.request.InventoryRequestDto;
import com.emranhss.GarmentsManagementSystem.dto.response.InventoryResponseDto;
import com.emranhss.GarmentsManagementSystem.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @PostMapping
    public ResponseEntity<InventoryResponseDto> create(@RequestBody InventoryRequestDto requestDto){
        return ResponseEntity.ok(inventoryService.create(requestDto));
    }

   @PutMapping("/{id}")
    public ResponseEntity<InventoryResponseDto>
   update(@PathVariable Long id, @RequestBody InventoryRequestDto requestDto){

        return ResponseEntity.ok(inventoryService.update( id, requestDto));
   }

   @GetMapping("/{id}")
    public ResponseEntity<InventoryResponseDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(inventoryService.getById(id));
   }

   @GetMapping
    public ResponseEntity<List<InventoryResponseDto>> getAll(){
        return ResponseEntity.ok(inventoryService.getAll());
   }

   @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){

        inventoryService.delete(id);
        return ResponseEntity.ok("Delete Successfully");
   }


}
