package com.example.laundry_project.repository;

import com.example.laundry_project.domain.orderstatusCategory.OrderStatusCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderstatusCategoryRepository extends JpaRepository<OrderStatusCategory, Integer> {
}
