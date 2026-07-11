package com.emranhss.GarmentsManagementSystem.repository;

import com.emranhss.GarmentsManagementSystem.entity.MaterialIssue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MaterialIssueRepository extends JpaRepository<MaterialIssue, Long> {

    Optional<MaterialIssue> findTopByOrderByIdDesc();
}
