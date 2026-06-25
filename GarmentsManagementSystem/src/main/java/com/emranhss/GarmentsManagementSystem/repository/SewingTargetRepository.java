package com.emranhss.GarmentsManagementSystem.repository;

import com.emranhss.GarmentsManagementSystem.entity.SewingTarget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SewingTargetRepository extends JpaRepository<SewingTarget, Long> {


//      All targets of a sewing plan

    List<SewingTarget> findBySewingPlanId(Long sewingPlanId);
}
