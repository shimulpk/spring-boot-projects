package com.emranhss.GarmentsManagementSystem.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "procurement_po_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProcurementPoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "po_id", nullable = false)
    @JsonIgnore
    private ProcurementPo procurementPo;

    @Column(nullable = false)
    private String materialName;

    @Column(nullable = false)
    private String unit;

    @Column(nullable = false)
    private BigDecimal quantity;

    @Column(nullable = false)
    private BigDecimal unitPrice;

    @Column(nullable = false)
    private BigDecimal lineTotal;
}
