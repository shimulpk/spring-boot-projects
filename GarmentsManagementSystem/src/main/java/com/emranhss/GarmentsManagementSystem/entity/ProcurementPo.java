package com.emranhss.GarmentsManagementSystem.entity;

import com.emranhss.GarmentsManagementSystem.enums.ProcurementPoStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "procurement_pos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProcurementPo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String poNumber;

    @Column(nullable = false)
    private LocalDate poDate;

    private LocalDate deliveryDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_id", nullable = false)
    @JsonIgnore
    private Vendor vendor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "requisition_id", nullable = false)
    @JsonIgnore
    private Requisition requisition;

    @Column(nullable = false)
    private BigDecimal taxPercent = BigDecimal.ZERO;

    @Column(nullable = false)
    private BigDecimal subTotal = BigDecimal.ZERO;

    @Column(nullable = false)
    private BigDecimal taxAmount = BigDecimal.ZERO;

    @Column(nullable = false)
    private BigDecimal grandTotal = BigDecimal.ZERO;

    @Enumerated(EnumType.STRING)
    private ProcurementPoStatus status;

    @OneToMany(
            mappedBy = "procurementPo",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ProcurementPoItem> items = new ArrayList<>();
}
