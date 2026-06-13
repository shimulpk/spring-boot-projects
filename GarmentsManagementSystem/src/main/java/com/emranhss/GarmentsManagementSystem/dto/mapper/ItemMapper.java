package com.emranhss.GarmentsManagementSystem.dto.mapper;

import com.emranhss.GarmentsManagementSystem.dto.request.ItemRequestDto;
import com.emranhss.GarmentsManagementSystem.dto.response.ItemResponseDto;
import com.emranhss.GarmentsManagementSystem.entity.Item;

public class ItemMapper {
    public static Item toEntity(ItemRequestDto dto){

        if(dto == null){
            return null;
        }

        Item item = new Item();

        item.setItemCode(dto.getItemCode());
        item.setItemName(dto.getItemName());
        item.setDescription(dto.getDescription());

        return item;
    }

    public static ItemResponseDto toDto(Item item){

        if(item == null){
            return null;
        }

        ItemResponseDto dto = new ItemResponseDto();

        dto.setId(item.getId());
        dto.setItemCode(item.getItemCode());
        dto.setItemName(item.getItemName());
        dto.setDescription(item.getDescription());

        if(item.getUom() != null){

            dto.setUomId(item.getUom().getId());
            dto.setUomName(item.getUom().getName());
            dto.setUomShortName(item.getUom().getShortName());
        }

        return dto;
    }
}
