package com.emranhss.GarmentsManagementSystem.serviceimp;

import com.emranhss.GarmentsManagementSystem.dto.mapper.RawMaterialCheckMapper;
import com.emranhss.GarmentsManagementSystem.dto.request.RawMaterialCheckRequestDto;
import com.emranhss.GarmentsManagementSystem.dto.response.RawMaterialCheckResponseDto;
import com.emranhss.GarmentsManagementSystem.entity.*;
import com.emranhss.GarmentsManagementSystem.repository.OrderRepository;
import com.emranhss.GarmentsManagementSystem.repository.RawMaterialCheckRepository;
import com.emranhss.GarmentsManagementSystem.repository.UomRepository;
import com.emranhss.GarmentsManagementSystem.service.RawMaterialCheckService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class RawMaterialCheckServiceImpl implements RawMaterialCheckService {

    private final RawMaterialCheckRepository rawMaterialCheckRepository;
    private final OrderRepository orderRepository;
    private final UomRepository uomRepository;


    @Override
    public RawMaterialCheckResponseDto generate(RawMaterialCheckRequestDto request) {
        Order order =
                orderRepository.findById(
                                request.getOrderId())
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Order Not Found"));

        RawMaterialCheck rmc =
                new RawMaterialCheck();

        rmc.setOrder(order);
        rmc.setStyle(order.getStyle());

        rmc.setOrderCode(
                order.getOrderId());

        rmc.setPoNumber(
                order.getPoNumber());

        rmc.setCreatedAt(
                LocalDateTime.now());

        BigDecimal totalFabric =
                BigDecimal.ZERO;

        for (OrderItem item : order.getItems()) {

            Optional<Uom> uomOptional =

                    uomRepository
                            .findByProductNameAndSize(
                                    item.getType(),
                                    item.getSize());

            RmcDetail detail =
                    new RmcDetail();

            detail.setProductName(
                    item.getType());

            detail.setSize(
                    item.getSize());

            detail.setType(
                    item.getType());

            detail.setQty(
                    item.getQuantity());

            detail.setRawMaterialCheck(rmc);

            if (uomOptional.isPresent()) {

                Uom uom =
                        uomOptional.get();

                BigDecimal baseFabric =
                        uom.getTotalBaseFabric();

                BigDecimal requiredFabric =

                        baseFabric.multiply(
                                BigDecimal.valueOf(
                                        item.getQuantity()));

                detail.setBaseFabric(
                        baseFabric);

                detail.setCalculatedFabric(
                        requiredFabric);

                detail.setHasUom(true);

                totalFabric =
                        totalFabric.add(
                                requiredFabric);

            } else {

                detail.setBaseFabric(
                        BigDecimal.ZERO);

                detail.setCalculatedFabric(
                        BigDecimal.ZERO);

                detail.setHasUom(false);
            }

            rmc.getDetails().add(detail);
        }

        rmc.setTotalFabricRequired(
                totalFabric);

        RawMaterialCheck saved =

                rawMaterialCheckRepository
                        .save(rmc);

        return RawMaterialCheckMapper
                .toDto(saved);
    }

    @Override
    public RawMaterialCheckResponseDto getById(Long id) {
        RawMaterialCheck rmc =
                rawMaterialCheckRepository
                        .findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "RMC Not Found"));

        return RawMaterialCheckMapper
                .toDto(rmc);
    }

    @Override
    public List<RawMaterialCheckResponseDto> getAll() {
        return rawMaterialCheckRepository
                .findAll()
                .stream()
                .map(RawMaterialCheckMapper::toDto)
                .toList();
    }

    @Override
    public void delete(Long id) {
        RawMaterialCheck rmc =
                rawMaterialCheckRepository
                        .findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "RMC Not Found"));

        rawMaterialCheckRepository
                .delete(rmc);
    }
}
