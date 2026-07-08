package com.emranhss.GarmentsManagementSystem.repository;

import com.emranhss.GarmentsManagementSystem.entity.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {

    boolean existsByPoNo(String poNo);
}
