package com.emranhss.GarmentsManagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "bom_styles")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BomStyle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String styleCode;

    @Column(nullable = false)
    private String styleName;

    private String styleType;

    @Column(length = 1000)
    private String description;

    private String approvalStatus;

    private String sizeSet;

    private Boolean active;

}
