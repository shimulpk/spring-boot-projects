package com.emranhss.GarmentsManagementSystem.entity;

import com.emranhss.GarmentsManagementSystem.enums.PurchaseRequisitionStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "purchase_requisitions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseRequisition {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String prNo;

    private LocalDate requisitionDate;

    private String requestedBy;

    private String department;

    private String remarks;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PurchaseRequisitionStatus status;


}
