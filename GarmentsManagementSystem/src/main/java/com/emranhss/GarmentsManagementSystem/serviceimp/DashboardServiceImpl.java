package com.emranhss.GarmentsManagementSystem.serviceimp;

import com.emranhss.GarmentsManagementSystem.dto.response.DashboardResponseDto;
import com.emranhss.GarmentsManagementSystem.enums.PurchaseOrderStatus;
import com.emranhss.GarmentsManagementSystem.enums.StoreRequisitionStatus;
import com.emranhss.GarmentsManagementSystem.repository.*;
import com.emranhss.GarmentsManagementSystem.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashboardService {


    private final UserRepository userRepository;
    private final BuyerRepository buyerRepository;
    private final VendorRepository vendorRepository;
    private final ItemRepository itemRepository;
    private final OrderRepository orderRepository;
    private final StoreRequisitionRepository storeRequisitionRepository;
    private final PurchaseOrderRepository purchaseOrderRepository;
    private final StockRepository stockRepository;
    private final DayWiseCuttingProductionRepository cuttingRepository;
    private final DayWiseSewingProductionRepository sewingRepository;
    private final DayWiseFinishingProductionRepository finishingRepository;


    @Override
    public DashboardResponseDto getDashboard() {
        DashboardResponseDto dto = new DashboardResponseDto();

        // ===============================
        // Master Counts
        // ===============================

        dto.setTotalUsers(userRepository.count());

        dto.setTotalBuyers(buyerRepository.count());

        dto.setTotalVendors(vendorRepository.count());

        dto.setTotalItems(itemRepository.count());

        dto.setTotalOrders(orderRepository.count());

        // ===============================
        // Pending
        // ===============================

        dto.setPendingRequisitions(
                (long) storeRequisitionRepository
                        .findByStatus(StoreRequisitionStatus.PENDING)
                        .size()
        );

        dto.setPendingPurchaseOrders(
                (long) purchaseOrderRepository
                        .findAllByStatus(PurchaseOrderStatus.PENDING)
                        .size()
        );

        // ===============================
        // Stock
        // ===============================

        dto.setCurrentStockItems(
                (long) stockRepository
                        .findByAvailableQuantityGreaterThan(0D)
                        .size()
        );

        // ===============================
        // Today's Production
        // ===============================

        dto.setTodayCuttingPcs(
                cuttingRepository
                        .getTodayCutting(LocalDate.now())
                        .longValue()
        );

        dto.setTodaySewingPcs(
                sewingRepository
                        .getTodaySewing(LocalDate.now())
                        .longValue()
        );

        dto.setTodayFinishingPcs(
                finishingRepository
                        .getTodayFinishing(LocalDate.now())
                        .longValue()
        );

        // Packing এখনও হয়নি

        dto.setTodayPackingPcs(0L);

        // ===============================
        // Order Tracking
        // ===============================

        dto.setOrderTracking(new ArrayList<>());

        return dto;
    }

    
    }

