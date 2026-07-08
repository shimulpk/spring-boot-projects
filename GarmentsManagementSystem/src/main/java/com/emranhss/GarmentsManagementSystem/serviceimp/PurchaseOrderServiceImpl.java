package com.emranhss.GarmentsManagementSystem.serviceimp;

import com.emranhss.GarmentsManagementSystem.dto.mapper.PurchaseOrderMapper;
import com.emranhss.GarmentsManagementSystem.dto.request.PurchaseOrderItemRequestDto;
import com.emranhss.GarmentsManagementSystem.dto.request.PurchaseOrderRequestDto;
import com.emranhss.GarmentsManagementSystem.dto.response.PurchaseOrderResponseDto;
import com.emranhss.GarmentsManagementSystem.entity.*;
import com.emranhss.GarmentsManagementSystem.enums.PurchaseOrderStatus;
import com.emranhss.GarmentsManagementSystem.repository.ItemRepository;
import com.emranhss.GarmentsManagementSystem.repository.PurchaseOrderRepository;
import com.emranhss.GarmentsManagementSystem.repository.StoreRequisitionRepository;
import com.emranhss.GarmentsManagementSystem.repository.VendorRepository;
import com.emranhss.GarmentsManagementSystem.service.PurchaseOrderService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    private final PurchaseOrderRepository purchaseOrderRepository;
    private final VendorRepository vendorRepository;
    private final StoreRequisitionRepository storeRequisitionRepository;
    private final ItemRepository itemRepository;


    @Override
    public PurchaseOrderResponseDto create(PurchaseOrderRequestDto request) {
        PurchaseOrder purchaseOrder =
                new PurchaseOrder();

        // PO Number
        String poNo = "PO-" + System.currentTimeMillis();

        purchaseOrder.setPoNo(poNo);

        purchaseOrder.setPoDate(
                request.getPoDate());

        Vendor vendor =
                vendorRepository.findById(
                                request.getVendorId())
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Vendor Not Found"));

        purchaseOrder.setVendor(vendor);

        StoreRequisition purchaseRequisition =
                storeRequisitionRepository.findById(
                                request.getStoreRequisitionId())
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Purchase Requisition Not Found"));

        purchaseOrder.setStoreRequisition(
                purchaseRequisition);

        purchaseOrder.setRemarks(
                request.getRemarks());

        purchaseOrder.setStatus(
                PurchaseOrderStatus.DRAFT);

        double grandTotal = 0.0;

        for (PurchaseOrderItemRequestDto itemDto
                : request.getItems()) {

            Item item =
                    itemRepository.findById(
                                    itemDto.getItemId())
                            .orElseThrow(() ->
                                    new RuntimeException(
                                            "Item Not Found"));

            PurchaseOrderItem purchaseOrderItem =
                    new PurchaseOrderItem();

            purchaseOrderItem.setPurchaseOrder(
                    purchaseOrder);

            purchaseOrderItem.setItem(item);

            purchaseOrderItem.setQuantity(
                    itemDto.getQuantity());

            purchaseOrderItem.setUnitPrice(
                    itemDto.getUnitPrice());

            purchaseOrderItem.setRemarks(
                    itemDto.getRemarks());

            purchaseOrder.getItems()
                    .add(purchaseOrderItem);

            grandTotal +=
                    itemDto.getQuantity()
                            * itemDto.getUnitPrice();
        }

        purchaseOrder.setGrandTotal(
                grandTotal);

        PurchaseOrder saved =
                purchaseOrderRepository.save(
                        purchaseOrder);

        return PurchaseOrderMapper.toDto(
                saved);
    }

    @Override
    public PurchaseOrderResponseDto update(Long id, PurchaseOrderRequestDto request) {
        PurchaseOrder purchaseOrder =
                purchaseOrderRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Purchase Order Not Found"));

        purchaseOrder.setPoDate(
                request.getPoDate());

        Vendor vendor =
                vendorRepository.findById(
                                request.getVendorId())
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Vendor Not Found"));

        purchaseOrder.setVendor(vendor);

        StoreRequisition purchaseRequisition =
                storeRequisitionRepository.findById(
                                request.getStoreRequisitionId())
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Purchase Requisition Not Found"));

        purchaseOrder.setStoreRequisition(
                purchaseRequisition);

        purchaseOrder.setRemarks(
                request.getRemarks());

        // Previous Items Remove
        purchaseOrder.getItems().clear();

        double grandTotal = 0.0;

        // New Items Add
        for (PurchaseOrderItemRequestDto itemDto
                : request.getItems()) {

            Item item =
                    itemRepository.findById(
                                    itemDto.getItemId())
                            .orElseThrow(() ->
                                    new RuntimeException(
                                            "Item Not Found"));

            PurchaseOrderItem purchaseOrderItem =
                    new PurchaseOrderItem();

            purchaseOrderItem.setPurchaseOrder(
                    purchaseOrder);

            purchaseOrderItem.setItem(item);

            purchaseOrderItem.setQuantity(
                    itemDto.getQuantity());

            purchaseOrderItem.setUnitPrice(
                    itemDto.getUnitPrice());

            purchaseOrderItem.setRemarks(
                    itemDto.getRemarks());

            purchaseOrder.getItems()
                    .add(purchaseOrderItem);

            grandTotal +=
                    itemDto.getQuantity()
                            * itemDto.getUnitPrice();
        }

        purchaseOrder.setGrandTotal(
                grandTotal);

        PurchaseOrder updated =
                purchaseOrderRepository.save(
                        purchaseOrder);

        return PurchaseOrderMapper.toDto(
                updated);
    }

    @Override
    public PurchaseOrderResponseDto getById(Long id) {
        PurchaseOrder purchaseOrder =
                purchaseOrderRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Purchase Order Not Found"));

        return PurchaseOrderMapper.toDto(
                purchaseOrder);
    }

    @Override
    public List<PurchaseOrderResponseDto> getAll() {
        return purchaseOrderRepository.findAll()
                .stream()
                .map(PurchaseOrderMapper::toDto)
                .toList();
    }

    @Override
    public void delete(Long id) {
        PurchaseOrder purchaseOrder =
                purchaseOrderRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Purchase Order Not Found"));

        purchaseOrderRepository.delete(
                purchaseOrder);
    }
}
