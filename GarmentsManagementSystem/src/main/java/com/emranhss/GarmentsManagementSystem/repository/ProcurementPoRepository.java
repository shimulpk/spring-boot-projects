package com.emranhss.GarmentsManagementSystem.repository;

import com.emranhss.GarmentsManagementSystem.entity.ProcurementPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcurementPoRepository extends JpaRepository<ProcurementPo, Long> {
    List<ProcurementPo> findByVendor_Id(Long vendorId);

    List<ProcurementPo> findByRequisition_Id(Long requisitionId);
}
