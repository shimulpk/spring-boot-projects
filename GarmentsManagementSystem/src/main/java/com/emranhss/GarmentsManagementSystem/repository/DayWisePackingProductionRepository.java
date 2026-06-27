package com.emranhss.GarmentsManagementSystem.repository;

import com.emranhss.GarmentsManagementSystem.entity.DayWisePackingProduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DayWisePackingProductionRepository extends JpaRepository<DayWisePackingProduction, Long> {

//     All Productions   of One Packing Plan


    List<DayWisePackingProduction> findByPackingPlanId(
            Long packingPlanId);
}
