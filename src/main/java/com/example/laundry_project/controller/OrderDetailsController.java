package com.example.laundry_project.controller;

import com.example.laundry_project.domain.orderDetails.OrderDetails;
import com.example.laundry_project.domain.orderDetails.OrderDetailsRequestDto;
import com.example.laundry_project.service.OrderDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class OrderDetailsController {
    private final OrderDetailsService orderDetailsService;

    @PostMapping("orderDetailsPro")
    public void addOrderDetails(@RequestBody OrderDetailsRequestDto orderDetailsRequestDto){
        OrderDetails orderDetails = new OrderDetails(orderDetailsRequestDto);
        orderDetailsService.addOrderDetails(orderDetails);
    }

}
