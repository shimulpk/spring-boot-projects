package com.emranhss.GarmentsManagementSystem.repository;

import com.emranhss.GarmentsManagementSystem.entity.StoreRequisitionItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRequisitionItemRepository extends JpaRepository<StoreRequisitionItem, Long> {


}
