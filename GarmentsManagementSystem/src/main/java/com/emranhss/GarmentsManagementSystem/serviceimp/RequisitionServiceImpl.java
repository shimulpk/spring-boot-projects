package com.emranhss.GarmentsManagementSystem.serviceimp;

import com.emranhss.GarmentsManagementSystem.dto.mapper.RequisitionMapper;
import com.emranhss.GarmentsManagementSystem.dto.request.RequisitionRequestDto;
import com.emranhss.GarmentsManagementSystem.dto.response.RequisitionResponseDto;
import com.emranhss.GarmentsManagementSystem.entity.Requisition;
import com.emranhss.GarmentsManagementSystem.enums.RequisitionStatus;
import com.emranhss.GarmentsManagementSystem.repository.RequisitionRepository;
import com.emranhss.GarmentsManagementSystem.service.RequisitionService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class RequisitionServiceImpl implements RequisitionService {

    private final RequisitionRepository requisitionRepository;

    @Override
    public RequisitionResponseDto create(RequisitionRequestDto request) {

        Requisition requisition =
                RequisitionMapper.toEntity(request);

        calculateTotal(requisition);

        requisition.setStatus(RequisitionStatus.PENDING);

        Requisition saved =
                requisitionRepository.save(requisition);

        return RequisitionMapper.toDto(saved);
    }

    @Override
    public RequisitionResponseDto update(Long id, RequisitionRequestDto request) {
        Requisition requisition =
                requisitionRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Requisition Not Found"));

        requisition.setPrDate(
                request.getPrDate());

        requisition.setDepartment(
                request.getDepartment());

        requisition.setRequestedBy(
                request.getRequestedBy());

        requisition.setCategoryName(
                request.getCategoryName());

        requisition.setOrderId(
                request.getOrderId());

        requisition.setQuantity(
                request.getQuantity());

        requisition.setUnitPrice(
                request.getUnitPrice());

        calculateTotal(requisition);

        Requisition updated =
                requisitionRepository.save(requisition);

        return RequisitionMapper.toDto(updated);
    }

    @Override
    public RequisitionResponseDto getById(Long id) {
        Requisition requisition =
                requisitionRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Requisition Not Found"));

        return RequisitionMapper.toDto(requisition);
    }

    @Override
    public List<RequisitionResponseDto> getAll() {
        return requisitionRepository.findAll()
                .stream()
                .map(RequisitionMapper::toDto)
                .toList();
    }

    @Override
    public void delete(Long id) {
        Requisition requisition =
                requisitionRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Requisition Not Found"));

        requisitionRepository.delete(requisition);
    }

    @Override
    public RequisitionResponseDto approve(Long id) {
        Requisition requisition =
                requisitionRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Requisition not found"));

        requisition.setStatus(
                RequisitionStatus.APPROVED);

        return RequisitionMapper.toDto(
                requisitionRepository.save(requisition));
    }

    @Override
    public RequisitionResponseDto reject(Long id) {
        Requisition requisition =
                requisitionRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Requisition not found"));

        requisition.setStatus(
                RequisitionStatus.REJECTED);

        return RequisitionMapper.toDto(
                requisitionRepository.save(requisition));
    }

    @Override
    public RequisitionResponseDto receive(Long id) {
        Requisition requisition =
                requisitionRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Requisition not found"));

        requisition.setStatus(
                RequisitionStatus.RECEIVED);

        return RequisitionMapper.toDto(
                requisitionRepository.save(requisition));
    }

    private void calculateTotal(
            Requisition requisition) {

        BigDecimal qty =
                requisition.getQuantity() == null
                        ? BigDecimal.ZERO
                        : requisition.getQuantity();

        BigDecimal unitPrice =
                requisition.getUnitPrice() == null
                        ? BigDecimal.ZERO
                        : requisition.getUnitPrice();

        requisition.setTotalPrice(
                qty.multiply(unitPrice));
    }
}
