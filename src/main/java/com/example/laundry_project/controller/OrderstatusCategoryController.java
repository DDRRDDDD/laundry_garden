package com.example.laundry_project.controller;

import com.example.laundry_project.domain.orderstatusCategory.OrderStatusCategory;
import com.example.laundry_project.repository.OrderstatusCategoryRepository;
import com.example.laundry_project.service.OrderstatusCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/orderstatuscategory")
@RequiredArgsConstructor
@RestController
public class OrderstatusCategoryController {

    private final OrderstatusCategoryService orderstatusCategoryService;
    private final OrderstatusCategoryRepository orderstatusCategoryRepository;


    @GetMapping("searchall")
    public List<OrderStatusCategory> getItemCategoryAll(){
        List<OrderStatusCategory> list = orderstatusCategoryService.getOrderstatusCategoryAll();
        return list;
    }

    @GetMapping("searchone")
    public OrderStatusCategory getItemCategoryByCode(int code){
        return orderstatusCategoryService.getOrderstatusCategoryByCode(code);
    }

}
