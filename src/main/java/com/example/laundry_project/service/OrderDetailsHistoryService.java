package com.example.laundry_project.service;

import com.example.laundry_project.domain.orderdetailshistory.OrderDetailsHistory;
import com.example.laundry_project.repository.OrderDetailsHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderDetailsHistoryService {

    private final OrderDetailsHistoryRepository orderDetailsHistoryRepository;

    public List<OrderDetailsHistory> getOrderDetailByOrderCode(int orderCode){
        return orderDetailsHistoryRepository.getAllByOrderCode(orderCode);
    }


}
