package com.emranhss.GarmentsManagementSystem.serviceimp;

import com.emranhss.GarmentsManagementSystem.dto.mapper.ProcurementPoMapper;
import com.emranhss.GarmentsManagementSystem.dto.request.ProcurementPoItemRequestDto;
import com.emranhss.GarmentsManagementSystem.dto.request.ProcurementPoRequestDto;
import com.emranhss.GarmentsManagementSystem.dto.response.ProcurementPoResponseDto;
import com.emranhss.GarmentsManagementSystem.entity.ProcurementPo;
import com.emranhss.GarmentsManagementSystem.entity.ProcurementPoItem;
import com.emranhss.GarmentsManagementSystem.entity.Requisition;
import com.emranhss.GarmentsManagementSystem.entity.Vendor;
import com.emranhss.GarmentsManagementSystem.enums.ProcurementPoStatus;
import com.emranhss.GarmentsManagementSystem.repository.ProcurementPoRepository;
import com.emranhss.GarmentsManagementSystem.repository.RequisitionRepository;
import com.emranhss.GarmentsManagementSystem.repository.VendorRepository;
import com.emranhss.GarmentsManagementSystem.service.ProcurementPoService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProcurementPoServiceImpl implements ProcurementPoService {

    private final ProcurementPoRepository procurementPoRepository;

    private final VendorRepository vendorRepository;

    private final RequisitionRepository requisitionRepository;


    @Override
    public ProcurementPoResponseDto create(ProcurementPoRequestDto request) {
        Vendor vendor =
                vendorRepository.findById(
                                request.getVendorId())
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Vendor Not Found"));

        Requisition requisition =
                requisitionRepository.findById(
                                request.getRequisitionId())
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Requisition Not Found"));

        ProcurementPo po =
                ProcurementPoMapper.toEntity(request);

        po.setVendor(vendor);

        po.setRequisition(requisition);

        po.setStatus(
                ProcurementPoStatus.DRAFT);

        BigDecimal subTotal =
                BigDecimal.ZERO;

        for (ProcurementPoItemRequestDto dto
                : request.getItems()) {

            ProcurementPoItem item =
                    ProcurementPoMapper
                            .toItemEntity(dto);

            item.setProcurementPo(po);

            BigDecimal lineTotal =
                    dto.getQuantity()
                            .multiply(
                                    dto.getUnitPrice());

            item.setLineTotal(
                    lineTotal);

            subTotal =
                    subTotal.add(
                            lineTotal);

            po.getItems()
                    .add(item);
        }

        BigDecimal taxAmount =
                subTotal.multiply(
                                request.getTaxPercent())
                        .divide(
                                BigDecimal.valueOf(100));

        BigDecimal grandTotal =
                subTotal.add(
                        taxAmount);

        po.setSubTotal(
                subTotal);

        po.setTaxAmount(
                taxAmount);

        po.setGrandTotal(
                grandTotal);

        ProcurementPo saved =
                procurementPoRepository
                        .save(po);

        return ProcurementPoMapper
                .toDto(saved);
    }

    @Override
    public ProcurementPoResponseDto update(Long id, ProcurementPoRequestDto request) {
        ProcurementPo po =
                procurementPoRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Purchase Order Not Found"));

        Vendor vendor =
                vendorRepository.findById(
                                request.getVendorId())
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Vendor Not Found"));

        Requisition requisition =
                requisitionRepository.findById(
                                request.getRequisitionId())
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Requisition Not Found"));

        po.setPoNumber(
                request.getPoNumber());

        po.setPoDate(
                request.getPoDate());

        po.setDeliveryDate(
                request.getDeliveryDate());

        po.setVendor(
                vendor);

        po.setRequisition(
                requisition);

        po.setTaxPercent(
                request.getTaxPercent());

        // পুরাতন Item Remove
        po.getItems().clear();

        BigDecimal subTotal =
                BigDecimal.ZERO;

        for (ProcurementPoItemRequestDto dto
                : request.getItems()) {

            ProcurementPoItem item =
                    ProcurementPoMapper
                            .toItemEntity(dto);

            item.setProcurementPo(po);

            BigDecimal lineTotal =
                    dto.getQuantity()
                            .multiply(
                                    dto.getUnitPrice());

            item.setLineTotal(
                    lineTotal);

            subTotal =
                    subTotal.add(
                            lineTotal);

            po.getItems().add(item);
        }

        BigDecimal taxAmount =
                subTotal.multiply(
                                request.getTaxPercent())
                        .divide(
                                BigDecimal.valueOf(100));

        BigDecimal grandTotal =
                subTotal.add(
                        taxAmount);

        po.setSubTotal(
                subTotal);

        po.setTaxAmount(
                taxAmount);

        po.setGrandTotal(
                grandTotal);

        ProcurementPo updated =
                procurementPoRepository
                        .save(po);

        return ProcurementPoMapper
                .toDto(updated);
    }

    @Override
    public ProcurementPoResponseDto getById(Long id) {
        ProcurementPo po =
                procurementPoRepository
                        .findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Purchase Order Not Found"));

        return ProcurementPoMapper.toDto(po);
    }

    @Override
    public List<ProcurementPoResponseDto> getAll() {
        return procurementPoRepository
                .findAll()
                .stream()
                .map(ProcurementPoMapper::toDto)
                .toList();
    }

    @Override
    public void delete(Long id) {
        ProcurementPo po =
                procurementPoRepository
                        .findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Purchase Order Not Found"));

        procurementPoRepository.delete(po);
    }

    @Override
    public ProcurementPoResponseDto issue(Long id) {
        ProcurementPo po =
                procurementPoRepository
                        .findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Purchase Order Not Found"));

        po.setStatus(
                ProcurementPoStatus.ISSUED);

        ProcurementPo updated =
                procurementPoRepository.save(po);

        return ProcurementPoMapper.toDto(updated);
    }

    @Override
    public ProcurementPoResponseDto receive(Long id) {
        ProcurementPo po =
                procurementPoRepository
                        .findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Purchase Order Not Found"));

        po.setStatus(
                ProcurementPoStatus.RECEIVED);

        ProcurementPo updated =
                procurementPoRepository.save(po);

        return ProcurementPoMapper.toDto(updated);
    }

    @Override
    public ProcurementPoResponseDto cancel(Long id) {
        ProcurementPo po =
                procurementPoRepository
                        .findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Purchase Order Not Found"));

        po.setStatus(
                ProcurementPoStatus.CANCELLED);

        ProcurementPo updated =
                procurementPoRepository.save(po);

        return ProcurementPoMapper.toDto(updated);
    }
}

