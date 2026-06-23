package com.emranhss.GarmentsManagementSystem.repository;

import com.emranhss.GarmentsManagementSystem.entity.CuttingPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CuttingPlanRepository extends JpaRepository<CuttingPlan, Long> {
    Optional<CuttingPlan> findByOrder_Id(Long orderId);

    boolean existsByOrder_Id(Long orderId);
}
