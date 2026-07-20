package com.emranhss.GarmentsManagementSystem.repository;

import com.emranhss.GarmentsManagementSystem.entity.DayWiseCuttingProduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DayWiseCuttingProductionRepository extends JpaRepository<DayWiseCuttingProduction, Long> {
    List<DayWiseCuttingProduction> findByCuttingPlanId(Long cuttingPlanId);
    Integer countByCuttingPlanId(Long cuttingPlanId);
    List<DayWiseCuttingProduction> findByCuttingPlanIdOrderByDateAsc(Long cuttingPlanId);

    @Query("""
select coalesce(sum(d.actualCutPieces),0)
from DayWiseCuttingProduction d
where d.cuttingPlan.id=:planId
""")
    Integer getTotalActualCut(Long planId);
    @Query("""
select coalesce(sum(d.rejectPieces),0)
from DayWiseCuttingProduction d
where d.cuttingPlan.id=:planId
""")
    Integer getTotalReject(Long planId);


    @Query("""
select coalesce(sum(d.actualCutPieces),0)
from DayWiseCuttingProduction d
where d.date=:date
""")
    Integer getTodayCutting(LocalDate date);


    @Query("""
select coalesce(sum(d.rejectPieces),0)
from DayWiseCuttingProduction d
where d.date=:date
""")
    Integer getTodayReject(LocalDate date);

    @Query("""
select d
from DayWiseCuttingProduction d
where d.date=:date
order by d.styleNo
""")
    List<DayWiseCuttingProduction> getTodayProductions(LocalDate date);



}
