package com.example.laundry_project.controller;

import com.example.laundry_project.domain.orderdetailshistory.OrderDetailsHistory;
import com.example.laundry_project.service.OrderDetailsHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class OrderDetailsHistoryController {

    private final OrderDetailsHistoryService orderDetailsHistoryService;

    @PostMapping("orderdetailHistory")
    public List<OrderDetailsHistory> getOrderDetailByOrderCode(@RequestParam int orderCode){
        List<OrderDetailsHistory> list = orderDetailsHistoryService.getOrderDetailByOrderCode(orderCode);
        return list;
    }
}
