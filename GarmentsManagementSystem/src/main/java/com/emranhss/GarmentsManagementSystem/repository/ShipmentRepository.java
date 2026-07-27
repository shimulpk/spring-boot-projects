package com.emranhss.GarmentsManagementSystem.repository;

import com.emranhss.GarmentsManagementSystem.entity.Shipment;
import com.emranhss.GarmentsManagementSystem.enums.ShipmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment,Long> {

    // Shipment No Check
    Optional<Shipment> findByShipmentNo(String shipmentNo);

    // Same Packing Plan can not create Shipment twice
    boolean existsByPackingPlanId(Long packingPlanId);

    // Shipment Status Wise List
    List<Shipment> findByStatus(ShipmentStatus status);

    // Dashboard
    long countByStatus(ShipmentStatus status);

    // Latest Shipment
    List<Shipment> findAllByOrderByShipmentDateDesc();


}
