package com.emranhss.GarmentsManagementSystem.repository;

import com.emranhss.GarmentsManagementSystem.entity.ProcurementPoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcurementPoItemRepository extends JpaRepository<ProcurementPoItem, Long> {

    List<ProcurementPoItem> findByProcurementPoId(Long poId);
}
