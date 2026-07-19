package com.emranhss.GarmentsManagementSystem.repository;

import com.emranhss.GarmentsManagementSystem.entity.DayWiseFinishingProduction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DayWiseFinishingProductionRepository extends JpaRepository<DayWiseFinishingProduction, Long> {

//    All Production of One Finishing Plan

    List<DayWiseFinishingProduction> findByFinishingPlanId(
            Long finishingPlanId);

    List<DayWiseFinishingProduction> findByFinishingPlanIdOrderByDateAsc(
            Long finishingPlanId);

    @Query("""
select coalesce(sum(d.passQty),0)
from DayWiseFinishingProduction d
where d.date=:date
""")
    Integer getTodayFinishing(LocalDate date);
}
