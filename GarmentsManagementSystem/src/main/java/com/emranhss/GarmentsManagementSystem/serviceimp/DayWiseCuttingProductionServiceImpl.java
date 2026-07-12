package com.emranhss.GarmentsManagementSystem.serviceimp;

import com.emranhss.GarmentsManagementSystem.dto.mapper.DayWiseCuttingProductionMapper;
import com.emranhss.GarmentsManagementSystem.dto.request.DayWiseCuttingProductionRequestDto;
import com.emranhss.GarmentsManagementSystem.dto.response.CuttingPlanProgressResponseDto;
import com.emranhss.GarmentsManagementSystem.dto.response.DayWiseCuttingProductionResponseDto;
import com.emranhss.GarmentsManagementSystem.entity.CuttingPlan;
import com.emranhss.GarmentsManagementSystem.entity.DayWiseCuttingProduction;
import com.emranhss.GarmentsManagementSystem.enums.CuttingPlanStatus;
import com.emranhss.GarmentsManagementSystem.repository.CuttingPlanRepository;
import com.emranhss.GarmentsManagementSystem.repository.DayWiseCuttingProductionRepository;
import com.emranhss.GarmentsManagementSystem.service.DayWiseCuttingProductionService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class DayWiseCuttingProductionServiceImpl implements DayWiseCuttingProductionService {

    private final DayWiseCuttingProductionRepository productionRepository;
    private final CuttingPlanRepository cuttingPlanRepository;

    @Override
    public DayWiseCuttingProductionResponseDto create(DayWiseCuttingProductionRequestDto request) {
        CuttingPlan plan =
                cuttingPlanRepository.findById(
                                request.getCuttingPlanId())
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Cutting Plan Not Found"));

        DayWiseCuttingProduction production =
                DayWiseCuttingProductionMapper.toEntity(request);

        production.setCuttingPlan(plan);

        production.setStyleNo(
                plan.getStyleNo());

        production.setCuttingMaster(
                plan.getCuttingMaster());

        DayWiseCuttingProduction saved =
                productionRepository.save(production);

        Integer totalCut =
                productionRepository
                        .findByCuttingPlanId(plan.getId())
                        .stream()
                        .mapToInt(
                                DayWiseCuttingProduction::getActualCutPieces)
                        .sum();

        if (totalCut >= plan.getPlannedPieces()) {

            plan.setStatus(
                    CuttingPlanStatus.COMPLETED);

            cuttingPlanRepository.save(plan);
        }

        return DayWiseCuttingProductionMapper
                .toDto(saved);
    }

    @Override
    public DayWiseCuttingProductionResponseDto getById(Long id) {
        DayWiseCuttingProduction dayWiseCuttingProduction = productionRepository.findById(id)
                .orElseThrow(()->
                new RuntimeException("CuttingProduction Not found"));
        return DayWiseCuttingProductionMapper.toDto(dayWiseCuttingProduction);
    }

    @Override
    public List<DayWiseCuttingProductionResponseDto> getAll() {
        return productionRepository.findAll()
                .stream()
                .map(DayWiseCuttingProductionMapper::toDto)
                .toList();
    }

    @Override
    public void delete(Long id) {
        productionRepository.deleteById(id);
    }

    @Override
    public CuttingPlanProgressResponseDto getProgress(Long cuttingPlanId) {
        CuttingPlan plan =
                cuttingPlanRepository.findById(cuttingPlanId)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Cutting Plan Not Found"));

        Integer cutSoFar =
                productionRepository
                        .findByCuttingPlanId(cuttingPlanId)
                        .stream()
                        .mapToInt(
                                DayWiseCuttingProduction::getActualCutPieces)
                        .sum();

        Integer target =
                plan.getPlannedPieces();

        Integer remaining =
                target - cutSoFar;

        Double progress =
                target == 0
                        ? 0.0
                        : (cutSoFar * 100.0) / target;

        Integer rejected =
                productionRepository
                        .getTotalReject(cuttingPlanId);

        CuttingPlanProgressResponseDto responseDto = new CuttingPlanProgressResponseDto();

        responseDto.setCutSoFar(cutSoFar);
        responseDto.setTarget(target);
        responseDto.setRemaining(remaining);
        responseDto.setProgress(progress);
        responseDto.setRejected(rejected);
        responseDto.setStatus(plan.getStatus());
        return responseDto;
    }

    @Override
    public List<DayWiseCuttingProductionResponseDto> getByCuttingPlan(Long cuttingPlanId) {
        return productionRepository
                .findByCuttingPlanIdOrderByDateAsc(cuttingPlanId)
                .stream()
                .map(DayWiseCuttingProductionMapper::toDto)
                .toList();

    }
}
