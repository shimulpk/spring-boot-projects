package com.emranhss.GarmentsManagementSystem.entity;

import com.emranhss.GarmentsManagementSystem.enums.ProcurementPoStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "procurement_pos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProcurementPo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String poNumber;

    private LocalDate poDate;

    private LocalDate deliveryDate;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    @JsonIgnore
    private Vendor vendor;

    @ManyToOne
    @JoinColumn(name = "requisition_id")
    @JsonIgnore
    private Requisition requisition;

    private String productName;

    private BigDecimal quantity;

    private BigDecimal unitPrice;

    private BigDecimal taxPercent;

    private BigDecimal totalPrice;

    private String vendorName;

    private String vendorPhone;

    @Enumerated(EnumType.STRING)
    private ProcurementPoStatus status;
}
