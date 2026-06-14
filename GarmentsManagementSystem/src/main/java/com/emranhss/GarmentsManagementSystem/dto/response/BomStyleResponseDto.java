package com.emranhss.GarmentsManagementSystem.dto.response;

import lombok.Data;

@Data
public class BomStyleResponseDto {
    private Long id;

    private String styleCode;

    private String styleName;

    private String styleType;

    private String description;

    private String approvalStatus;

    private String sizeSet;

    private Boolean active;
}
