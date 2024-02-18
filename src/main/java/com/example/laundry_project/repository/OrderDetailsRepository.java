package com.example.laundry_project.repository;

import com.example.laundry_project.domain.orderDetails.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailsRepository  extends JpaRepository<OrderDetails, Integer> {
    public List<OrderDetails> getAllByOrderCode(int orderCode);
}
