package com.emranhss.GarmentsManagementSystem.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShipmentRequestDto {

    // User Select
    private Long packingPlanId;

    // User Input
    private LocalDate shipmentDate;

    private String destination;

    private String transportName;

    private String vehicleNo;

    private String remarks;
}
