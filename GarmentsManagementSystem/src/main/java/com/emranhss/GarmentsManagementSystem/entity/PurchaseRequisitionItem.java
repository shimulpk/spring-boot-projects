package com.emranhss.GarmentsManagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "purchase_requisition_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseRequisitionItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "purchase_requisition_id")
    private PurchaseRequisition purchaseRequisition;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    private Double quantity;

    private String remarks;
}
