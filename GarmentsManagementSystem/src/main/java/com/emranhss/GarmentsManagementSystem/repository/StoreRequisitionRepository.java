package com.emranhss.GarmentsManagementSystem.repository;

import com.emranhss.GarmentsManagementSystem.entity.StoreRequisition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRequisitionRepository extends JpaRepository<StoreRequisition, Long> {

    boolean existsByPrNo(String prNo);

}
