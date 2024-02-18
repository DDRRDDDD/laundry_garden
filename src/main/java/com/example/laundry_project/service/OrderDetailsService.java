package com.example.laundry_project.service;

import com.example.laundry_project.domain.orderDetails.OrderDetails;
import com.example.laundry_project.repository.OrderDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderDetailsService {
    private final OrderDetailsRepository orderDetailsRepository;
    // C
    public void addOrderDetails(OrderDetails orderDetails){
        orderDetailsRepository.save(orderDetails);
    }

    // R
    public List<OrderDetails> getAllByOrderCode(int orderCode) {
        return orderDetailsRepository.getAllByOrderCode(orderCode);
    }
}
