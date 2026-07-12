package com.emranhss.GarmentsManagementSystem.repository;

import com.emranhss.GarmentsManagementSystem.entity.DayWiseSewingProduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DayWiseSewingProductionRepository extends JpaRepository<DayWiseSewingProduction, Long> {

//    All production entries of a Sewing Plan

    List<DayWiseSewingProduction>
    findBySewingPlanId(Long sewingPlanId);


//      Used for Line Progress,Achieved So Far, Remaining

    List<DayWiseSewingProduction>
    findBySewingPlanIdAndProductionLineId(
            Long sewingPlanId,
            Long productionLineId
    );


    @Query("""
select coalesce(sum(d.achievedQuantity),0)
from DayWiseSewingProduction d
where d.sewingPlan.id=:sewingPlanId
and d.productionLine.id=:productionLineId
""")
    Integer getAchievedQty(
            Long sewingPlanId,
            Long productionLineId);


    @Query("""
select coalesce(sum(d.rejectionQty),0)
from DayWiseSewingProduction d
where d.sewingPlan.id=:sewingPlanId
and d.productionLine.id=:productionLineId
""")
    Integer getRejectQty(
            Long sewingPlanId,
            Long productionLineId);
}
