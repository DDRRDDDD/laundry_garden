package com.example.laundry_project.repository;

import com.example.laundry_project.domain.orderdetailshistory.OrderDetailsHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailsHistoryRepository extends JpaRepository<OrderDetailsHistory, Integer> {

    public List<OrderDetailsHistory> getAllByOrderCode(int orderCode);
}
