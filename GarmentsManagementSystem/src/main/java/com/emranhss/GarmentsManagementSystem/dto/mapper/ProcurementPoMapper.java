package com.emranhss.GarmentsManagementSystem.dto.mapper;

import com.emranhss.GarmentsManagementSystem.dto.request.ProcurementPoRequestDto;
import com.emranhss.GarmentsManagementSystem.dto.response.ProcurementPoResponseDto;
import com.emranhss.GarmentsManagementSystem.entity.ProcurementPo;
import com.emranhss.GarmentsManagementSystem.entity.Requisition;

public class ProcurementPoMapper {

    public static ProcurementPo toEntity(
            ProcurementPoRequestDto dto, Requisition requisition) {

        if (dto == null) {
            return null;
        }

        ProcurementPo po = new ProcurementPo();

        po.setPoNumber(dto.getPoNumber());
        po.setPoDate(dto.getPoDate());
        po.setDeliveryDate(dto.getDeliveryDate());
        po.setTaxPercent(dto.getTaxPercent());

        if(requisition != null){

            po.setProductName(requisition.getCategoryName());
            po.setQuantity(requisition.getQuantity());
            po.setUnitPrice(requisition.getUnitPrice());
        }




        return po;
    }

    public static ProcurementPoResponseDto toDto(
            ProcurementPo po) {

        if (po == null) {
            return null;
        }

        ProcurementPoResponseDto dto =
                new ProcurementPoResponseDto();

        dto.setId(po.getId());

        dto.setPoNumber(po.getPoNumber());
        dto.setPoDate(po.getPoDate());
        dto.setDeliveryDate(po.getDeliveryDate());

        dto.setProductName(po.getProductName());

        dto.setQuantity(po.getQuantity());
        dto.setUnitPrice(po.getUnitPrice());
        dto.setTaxPercent(po.getTaxPercent());

        dto.setTotalPrice(po.getTotalPrice());

        dto.setStatus(po.getStatus());

        if (po.getVendor() != null) {

            dto.setVendorId(
                    po.getVendor().getId());

            dto.setVendorName(
                    po.getVendor().getCompanyName());

            dto.setVendorPhone(
                    po.getVendor().getPhone());
        }

        if (po.getRequisition() != null) {

            dto.setRequisitionId(
                    po.getRequisition().getId());
        }

        return dto;
    }
}
