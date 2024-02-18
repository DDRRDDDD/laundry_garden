package com.example.laundry_project.controller;

import com.example.laundry_project.domain.client.Client;
import com.example.laundry_project.domain.orderView.OrderView;
import com.example.laundry_project.service.OrderViewService;
import com.example.laundry_project.service.OrderstatusCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;
import java.util.List;


@RequiredArgsConstructor
@RestController
public class OrderViewController {

    private final OrderViewService orderViewService;
    private final OrderstatusCategoryService orderstatusCategoryService;


    // pageable 처리 전
    @PostMapping("myoders")
    public List<OrderView> getOrderByClientCode(HttpSession session){
        Client client = (Client) session.getAttribute("loginClient");

        List<OrderView> list = orderViewService.getOrderByClientCode(client.getClientCode());
        return list;
    }
}
