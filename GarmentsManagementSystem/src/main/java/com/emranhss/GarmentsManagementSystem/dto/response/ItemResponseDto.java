package com.emranhss.GarmentsManagementSystem.dto.response;

import lombok.Data;

@Data
public class ItemResponseDto {
    private Long id;

    private String itemCode;

    private String itemName;

    private String description;

    private Long uomId;

    private String uomName;

    private String uomShortName;
}
