package com.emranhss.GarmentsManagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "buyers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

    @Column(unique = true)
    private String buyerCode;

    private String buyerName;

    private String country;

    private String address;

    private String website;

    private String currency;

    private String paymentTerms;

    private Boolean active;

    @OneToMany(
            mappedBy = "buyer",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<BuyerContact> contacts = new ArrayList<>();
}
