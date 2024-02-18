package com.example.laundry_project.controller;


import com.example.laundry_project.domain.client.Client;
import com.example.laundry_project.domain.order.Order;
import com.example.laundry_project.domain.order.OrderRequestDto;
import com.example.laundry_project.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;

import java.sql.Timestamp;
import java.util.List;

@RequestMapping("order")
@RequiredArgsConstructor
@RestController
public class OrderController {

    private final OrderService orderService;

    @PostMapping("create")
    public Order addOrder(@RequestBody OrderRequestDto orderDto){
        Order order = new Order(orderDto);
        orderService.addOrder(order);
        return order;
    }

    @PostMapping("searchall")
    public List<Order> getOrderAll(){
        List<Order> list = orderService.getOrderAll();
        return list;
    }


    // pageable 처리 전 <사용안함>
    // 모델어노테이션 사용하여 loginClient 가져오기
    @PostMapping("searchallclient")
    public List<Order> getOrderAllByClientCode(@ModelAttribute("loginClient") Client client){
        List<Order> list = orderService.getOrderAllByClientCode(client.getClientCode());
        return list;
    }

/*    @PostMapping("searchallclient")
    public List<Order> getOrderAllByClientCode(Model model){
        Client client = (Client) model.getAttribute("loginClient");
        List<Order> list = orderService.getOrderAllByClientCode(client.getClientCode());
        return list;
    }*/

    @PostMapping("orderByorderCode")
    public Order getOrderByOrderCode(@RequestParam int orderCode){
        Order order = orderService.getOrderByOrderCode(orderCode);
        return order;
    }

    @GetMapping("orderbystatus")
    public List<Order> getOrderByStatus(int code) {
        List<Order> list = orderService.getOrderByStatusCode(code);
        return list;
    }

    @PutMapping("update")
    public void updateOrderByOrderCode(@RequestBody OrderRequestDto orderDto){
        Order order = new Order(orderDto);
        orderService.updateOrderByOrderCode(order);
    }

    @PutMapping("registPaymentDate")
    public void updatePaymentDateByOrderCode(@RequestParam int orderCode){
        orderService.updatePaymentDateByOrderCode(orderCode);
    }

    @PutMapping("updateIsWritten")
    public void updateIsWrittenByOrderCode(@RequestParam int orderCode){
        orderService.updateIsWrittenByOrderCode(orderCode);
    }

    @PutMapping("changeStatus")
    public void updateStatusByOrderCode(@RequestParam int statusCode, @RequestParam int orderCode){
        orderService.updateStatusByOrderCode(statusCode, orderCode);
    }

    @DeleteMapping("remove")
    public void deleteOrderByOrderCode(@RequestParam int orderCode){
        orderService.deleteOrderByOrderCode(orderCode);
    }

}
