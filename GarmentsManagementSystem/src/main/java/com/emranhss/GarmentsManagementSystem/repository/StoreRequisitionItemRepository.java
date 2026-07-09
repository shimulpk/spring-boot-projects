package com.emranhss.GarmentsManagementSystem.repository;

import com.emranhss.GarmentsManagementSystem.entity.StoreRequisition;
import com.emranhss.GarmentsManagementSystem.entity.StoreRequisitionItem;
import com.emranhss.GarmentsManagementSystem.enums.StoreRequisitionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRequisitionItemRepository extends JpaRepository<StoreRequisitionItem, Long> {


}
