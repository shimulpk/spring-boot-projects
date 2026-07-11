package com.emranhss.GarmentsManagementSystem.repository;

import com.emranhss.GarmentsManagementSystem.entity.DayWiseCuttingProduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DayWiseCuttingProductionRepository extends JpaRepository<DayWiseCuttingProduction, Long> {
    List<DayWiseCuttingProduction> findByCuttingPlanId(Long cuttingPlanId);

    Integer countByCuttingPlanId(Long cuttingPlanId);

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
}
