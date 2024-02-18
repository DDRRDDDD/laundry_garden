package com.example.laundry_project.service;


import com.example.laundry_project.domain.orderstatusCategory.OrderStatusCategory;
import com.example.laundry_project.repository.OrderstatusCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderstatusCategoryService {

    private final OrderstatusCategoryRepository orderstatusCategoryRepository;

    // Create
    // Read
    public List<OrderStatusCategory> getOrderstatusCategoryAll(){
        return orderstatusCategoryRepository.findAll();
    }

    public OrderStatusCategory getOrderstatusCategoryByCode(int code){
        OrderStatusCategory orderstatusCategory = null;

        orderstatusCategory = orderstatusCategoryRepository.findById(code).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 주문상태 입니다.")
        );
        return orderstatusCategory;
    }

    // Update
    // Delete
}
