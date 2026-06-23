package com.emranhss.GarmentsManagementSystem.repository;

import com.emranhss.GarmentsManagementSystem.entity.RawMaterialCheck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RawMaterialCheckRepository extends JpaRepository<RawMaterialCheck , Long> {
    Optional<RawMaterialCheck> findByOrder_Id(Long orderId);
}
