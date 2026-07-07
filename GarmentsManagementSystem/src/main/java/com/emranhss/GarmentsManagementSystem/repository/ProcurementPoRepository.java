package com.emranhss.GarmentsManagementSystem.repository;

import com.emranhss.GarmentsManagementSystem.entity.ProcurementPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProcurementPoRepository extends JpaRepository<ProcurementPo, Long> {
    Optional<ProcurementPo> findByPoNumber(String poNumber);


}
