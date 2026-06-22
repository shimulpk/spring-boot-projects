package com.emranhss.GarmentsManagementSystem.serviceimp;

import com.emranhss.GarmentsManagementSystem.dto.mapper.ProcurementPoMapper;
import com.emranhss.GarmentsManagementSystem.dto.request.ProcurementPoRequestDto;
import com.emranhss.GarmentsManagementSystem.dto.response.ProcurementPoResponseDto;
import com.emranhss.GarmentsManagementSystem.entity.ProcurementPo;
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
                vendorRepository.findById(request.getVendorId())
                        .orElseThrow(() ->
                                new RuntimeException("Vendor Not Found"));

        Requisition requisition =
                requisitionRepository.findById(
                                request.getRequisitionId())
                        .orElseThrow(() ->
                                new RuntimeException("Requisition Not Found"));

        ProcurementPo po =
                ProcurementPoMapper.toEntity(request,requisition);

        po.setVendor(vendor);
        po.setRequisition(requisition);

        po.setVendorName(vendor.getCompanyName());
        po.setVendorPhone(vendor.getPhone());

        BigDecimal subtotal =
                requisition.getQuantity()
                        .multiply(requisition.getUnitPrice());

        BigDecimal tax =
                subtotal.multiply(
                                request.getTaxPercent())
                        .divide(BigDecimal.valueOf(100));

        po.setTotalPrice(subtotal.add(tax));

        po.setStatus(
                ProcurementPoStatus.DRAFT);

        ProcurementPo saved =
                procurementPoRepository.save(po);

        return ProcurementPoMapper.toDto(saved);
    }

    @Override
    public ProcurementPoResponseDto update(Long id, ProcurementPoRequestDto request) {
        ProcurementPo po =
                procurementPoRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("PO Not Found"));

        Vendor vendor =
                vendorRepository.findById(request.getVendorId())
                        .orElseThrow(() ->
                                new RuntimeException("Vendor Not Found"));

        Requisition requisition =
                requisitionRepository.findById(
                                request.getRequisitionId())
                        .orElseThrow(() ->
                                new RuntimeException("Requisition Not Found"));

        po.setPoNumber(request.getPoNumber());
        po.setPoDate(request.getPoDate());
        po.setDeliveryDate(request.getDeliveryDate());
        po.setTaxPercent(request.getTaxPercent());

        po.setVendor(vendor);
        po.setRequisition(requisition);

        po.setVendorName(vendor.getCompanyName());
        po.setVendorPhone(vendor.getPhone());

        po.setProductName(requisition.getCategoryName());
        po.setQuantity(requisition.getQuantity());
        po.setUnitPrice(requisition.getUnitPrice());


        BigDecimal subtotal =
                requisition.getQuantity()
                        .multiply(requisition.getUnitPrice());

        BigDecimal tax =
                subtotal.multiply(
                                request.getTaxPercent())
                        .divide(BigDecimal.valueOf(100));

        po.setTotalPrice(subtotal.add(tax));

        return ProcurementPoMapper.toDto(
                procurementPoRepository.save(po));
    }

    @Override
    public ProcurementPoResponseDto getById(Long id) {
        return ProcurementPoMapper.toDto(
                procurementPoRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("PO Not Found")));
    }

    @Override
    public List<ProcurementPoResponseDto> getAll() {
        return procurementPoRepository.findAll()
                .stream()
                .map(ProcurementPoMapper::toDto)
                .toList();
    }

    @Override
    public void delete(Long id) {
        procurementPoRepository.deleteById(id);
    }

    @Override
    public ProcurementPoResponseDto issue(Long id) {
        ProcurementPo po =
                procurementPoRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("PO Not Found"));

        po.setStatus(
                ProcurementPoStatus.ISSUED);

        return ProcurementPoMapper.toDto(
                procurementPoRepository.save(po));
    }

    @Override
    public ProcurementPoResponseDto receive(Long id) {
        ProcurementPo po =
                procurementPoRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("PO Not Found"));

        po.setStatus(
                ProcurementPoStatus.RECEIVED);

        return ProcurementPoMapper.toDto(
                procurementPoRepository.save(po));
    }

    @Override
    public ProcurementPoResponseDto cancel(Long id) {
        ProcurementPo po =
                procurementPoRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("PO Not Found"));

        po.setStatus(
                ProcurementPoStatus.CANCELLED);

        return ProcurementPoMapper.toDto(
                procurementPoRepository.save(po));
    }
    }

