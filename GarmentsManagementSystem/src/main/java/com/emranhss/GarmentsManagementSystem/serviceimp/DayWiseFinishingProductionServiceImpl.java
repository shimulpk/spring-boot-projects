package com.emranhss.GarmentsManagementSystem.serviceimp;


import com.emranhss.GarmentsManagementSystem.dto.mapper.DayWiseFinishingProductionMapper;
import com.emranhss.GarmentsManagementSystem.dto.request.DayWiseFinishingProductionRequestDto;
import com.emranhss.GarmentsManagementSystem.dto.response.DayWiseFinishingProductionResponseDto;
import com.emranhss.GarmentsManagementSystem.dto.response.FinishingProgressResponseDto;
import com.emranhss.GarmentsManagementSystem.entity.DayWiseFinishingProduction;
import com.emranhss.GarmentsManagementSystem.entity.FinishingPlan;
import com.emranhss.GarmentsManagementSystem.enums.FinishingPlanStatus;
import com.emranhss.GarmentsManagementSystem.repository.DayWiseFinishingProductionRepository;
import com.emranhss.GarmentsManagementSystem.repository.FinishingPlanRepository;
import com.emranhss.GarmentsManagementSystem.service.DayWiseFinishingProductionService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class DayWiseFinishingProductionServiceImpl implements DayWiseFinishingProductionService {

    private final DayWiseFinishingProductionRepository dayWiseFinishingProductionRepository;

    private final FinishingPlanRepository finishingPlanRepository;


    @Override
    public DayWiseFinishingProductionResponseDto create(DayWiseFinishingProductionRequestDto request) {
//        Load Finishing Plan

        FinishingPlan finishingPlan =
                finishingPlanRepository.findById(
                                request.getFinishingPlanId())
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Finishing Plan Not Found"));

        DayWiseFinishingProduction production =
                new DayWiseFinishingProduction();

        production.setFinishingPlan(
                finishingPlan);

        production.setDate(
                request.getDate());

        production.setPassQty(
                request.getPassQty());

        production.setRejectQty(
                request.getRejectQty());

        production.setRemarks(
                request.getRemarks());

//        Auto Fill

        production.setStyleNo(
                finishingPlan.getStyleNo());

        production.setBuyerName(
                finishingPlan.getBuyerName());

        DayWiseFinishingProduction saved =
                dayWiseFinishingProductionRepository
                        .save(production);

//        Update Finishing Plan Pass Qty, Reject Qty, Status

        recalculateAndSaveFinishingPlan(finishingPlan);
        return DayWiseFinishingProductionMapper.toDto(saved);


    }

    @Override
    public DayWiseFinishingProductionResponseDto update(Long id, DayWiseFinishingProductionRequestDto request) {
        DayWiseFinishingProduction production =
                dayWiseFinishingProductionRepository
                        .findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Production Not Found"));

        production.setDate(
                request.getDate());

        production.setPassQty(
                request.getPassQty());

        production.setRejectQty(
                request.getRejectQty());

        production.setRemarks(
                request.getRemarks());

        DayWiseFinishingProduction updated =
                dayWiseFinishingProductionRepository
                        .save(production);

//        Recalculate Finishing Plan

        recalculateAndSaveFinishingPlan(production.getFinishingPlan());
        return DayWiseFinishingProductionMapper.toDto(updated);
    }

    @Override
    public DayWiseFinishingProductionResponseDto getById(Long id) {
        return DayWiseFinishingProductionMapper
                .toDto(
                        dayWiseFinishingProductionRepository
                                .findById(id)
                                .orElseThrow(() ->
                                        new RuntimeException(
                                                "Production Not Found")));
    }

    @Override
    public List<DayWiseFinishingProductionResponseDto> getAll() {
        return dayWiseFinishingProductionRepository
                .findAll()
                .stream()
                .map(
                        DayWiseFinishingProductionMapper
                                ::toDto)
                .toList();
    }

    @Override
    public void delete(Long id) {
        // id diye khoja
        DayWiseFinishingProduction production = dayWiseFinishingProductionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Production Not Found"));

        // Delete korar age variable e rakha
        FinishingPlan finishingPlan = production.getFinishingPlan();


        dayWiseFinishingProductionRepository.delete(production);

        // ৪. ডিলিট করার পর মেইন প্ল্যানের টোটাল হিসাব আবার নতুন করে করার জন্য মেথড কল করছি
        recalculateAndSaveFinishingPlan(finishingPlan);
    }

    @Override
    public FinishingProgressResponseDto getProgress(Long finishingPlanId) {
        FinishingPlan finishingPlan =
                finishingPlanRepository.findById(
                                finishingPlanId)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Finishing Plan Not Found"));

        List<DayWiseFinishingProduction> productions =
                dayWiseFinishingProductionRepository
                        .findByFinishingPlanId(
                                finishingPlanId);

        int totalPass =
                productions.stream()
                        .mapToInt(p ->
                                p.getPassQty() == null
                                        ? 0
                                        : p.getPassQty())
                        .sum();

        int remaining =
                finishingPlan.getTargetQty()
                        - totalPass;

        if (remaining < 0) {
            remaining = 0;
        }

        return new FinishingProgressResponseDto(
                finishingPlan.getTargetQty(),
                totalPass,
                remaining
        );
    }



    private void recalculateAndSaveFinishingPlan(FinishingPlan finishingPlan) {
        List<DayWiseFinishingProduction> productions = dayWiseFinishingProductionRepository
                .findByFinishingPlanId(finishingPlan.getId());

        int totalPass = productions.stream()
                .mapToInt(p -> p.getPassQty() == null ? 0 : p.getPassQty())
                .sum();

        int totalReject = productions.stream()
                .mapToInt(p -> p.getRejectQty() == null ? 0 : p.getRejectQty())
                .sum();

        finishingPlan.setPassQty(totalPass);
        finishingPlan.setRejectionQty(totalReject);

//        Target fill hole Complete na hole inProgress

        if (totalPass >= finishingPlan.getTargetQty()) {
            finishingPlan.setStatus(FinishingPlanStatus.COMPLETED);
        } else {

            finishingPlan.setStatus(FinishingPlanStatus.IN_PROGRESS);
        }

        finishingPlanRepository.save(finishingPlan);
    }
}
