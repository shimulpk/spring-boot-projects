package com.emranhss.GarmentsManagementSystem.dto.request;

import lombok.Data;

@Data
public class ItemRequestDto {
    private String itemCode;

    private String itemName;

    private String description;

    private Long uomId;
}
