package com.emranhss.GarmentsManagementSystem.dto.mapper;

import com.emranhss.GarmentsManagementSystem.dto.response.PurchaseOrderResponseDto;
import com.emranhss.GarmentsManagementSystem.entity.PurchaseOrder;

public class PurchaseOrderMapper {

    public static PurchaseOrderResponseDto toDto(
            PurchaseOrder purchaseOrder) {

        if (purchaseOrder == null) {
            return null;
        }

        PurchaseOrderResponseDto dto =
                new PurchaseOrderResponseDto();

        dto.setId(
                purchaseOrder.getId());

        dto.setPoNo(
                purchaseOrder.getPoNo());

        dto.setPoDate(
                purchaseOrder.getPoDate());

        dto.setVendorId(
                purchaseOrder.getVendor().getId());

        dto.setVendorName(
                purchaseOrder.getVendor().getCompanyName());

        dto.setPurchaseRequisitionId(
                purchaseOrder.getStoreRequisition().getId());

        dto.setRemarks(
                purchaseOrder.getRemarks());

        dto.setStatus(
                purchaseOrder.getStatus());

        dto.setGrandTotal(
                purchaseOrder.getGrandTotal());

        dto.setItems(
                purchaseOrder.getItems()
                        .stream()
                        .map(PurchaseOrderItemMapper::toDto)
                        .toList());

        return dto;
    }

}
