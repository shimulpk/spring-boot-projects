package com.emranhss.GarmentsManagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "machines")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Machine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String machineId;

    private String machineName;

    private String type;

    @ManyToOne
    @JoinColumn(name = "production_line_id")
    private ProductionLine productionLine;

    private Boolean active;
}
