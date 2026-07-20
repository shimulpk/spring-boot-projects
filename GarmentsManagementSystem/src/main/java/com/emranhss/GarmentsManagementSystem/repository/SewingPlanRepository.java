package com.emranhss.GarmentsManagementSystem.repository;

import com.emranhss.GarmentsManagementSystem.entity.SewingPlan;
import com.emranhss.GarmentsManagementSystem.enums.SewingPlanStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SewingPlanRepository extends JpaRepository<SewingPlan, Long> {
    Optional<SewingPlan> findBySewingPlanId(String sewingPlanId);

    List<SewingPlan> findByStatus(SewingPlanStatus status);

    long countByStatus(SewingPlanStatus status);

    List<SewingPlan> findTop5ByOrderByStartDateDesc();
}
