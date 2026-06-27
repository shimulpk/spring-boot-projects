package com.emranhss.GarmentsManagementSystem.repository;

import com.emranhss.GarmentsManagementSystem.entity.DayWiseFinishingProduction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DayWiseFinishingProductionRepository extends JpaRepository<DayWiseFinishingProduction, Long> {

//    All Production of One Finishing Plan

    List<DayWiseFinishingProduction> findByFinishingPlanId(
            Long finishingPlanId);
}
