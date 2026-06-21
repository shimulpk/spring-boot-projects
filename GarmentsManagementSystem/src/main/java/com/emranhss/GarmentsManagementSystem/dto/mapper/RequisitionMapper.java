package com.emranhss.GarmentsManagementSystem.dto.mapper;

import com.emranhss.GarmentsManagementSystem.dto.request.RequisitionRequestDto;
import com.emranhss.GarmentsManagementSystem.dto.response.RequisitionResponseDto;
import com.emranhss.GarmentsManagementSystem.entity.Requisition;

public class RequisitionMapper {
    public static Requisition toEntity(
            RequisitionRequestDto dto) {

        if (dto == null) {
            return null;
        }

        Requisition requisition =
                new Requisition();

        requisition.setPrDate(
                dto.getPrDate());

        requisition.setDepartment(
                dto.getDepartment());

        requisition.setRequestedBy(
                dto.getRequestedBy());

        requisition.setCategoryName(
                dto.getCategoryName());

        requisition.setOrderId(
                dto.getOrderId());

        requisition.setQuantity(
                dto.getQuantity());

        requisition.setUnitPrice(
                dto.getUnitPrice());

        return requisition;
    }

    public static RequisitionResponseDto toDto(
            Requisition requisition) {

        if (requisition == null) {
            return null;
        }

        RequisitionResponseDto dto =
                new RequisitionResponseDto();

        dto.setId(requisition.getId());

        dto.setPrDate(
                requisition.getPrDate());

        dto.setDepartment(
                requisition.getDepartment());

        dto.setRequestedBy(
                requisition.getRequestedBy());

        dto.setCategoryName(
                requisition.getCategoryName());

        dto.setOrderId(
                requisition.getOrderId());

        dto.setQuantity(
                requisition.getQuantity());

        dto.setUnitPrice(
                requisition.getUnitPrice());

        dto.setTotalPrice(
                requisition.getTotalPrice());

        dto.setStatus(requisition.getStatus());

        return dto;
    }
}
