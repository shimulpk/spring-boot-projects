package com.emranhss.GarmentsManagementSystem.repository;

import com.emranhss.GarmentsManagementSystem.entity.DayWiseCuttingProduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DayWiseCuttingProductionRepository extends JpaRepository<DayWiseCuttingProduction, Long> {
    List<DayWiseCuttingProduction>
    findByCuttingPlanId(Long cuttingPlanId);
}
