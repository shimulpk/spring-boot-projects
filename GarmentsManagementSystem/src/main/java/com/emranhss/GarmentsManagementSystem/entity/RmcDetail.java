package com.emranhss.GarmentsManagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "rmc_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RmcDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;

    private String size;

    private String type;

    private BigDecimal baseFabric;

    private Integer qty;

    private BigDecimal calculatedFabric;

    private Boolean hasUom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rmc_id")
    private RawMaterialCheck rawMaterialCheck;
}
