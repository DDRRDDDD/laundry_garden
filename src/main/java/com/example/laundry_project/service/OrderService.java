package com.example.laundry_project.service;


import com.example.laundry_project.domain.order.Order;
import com.example.laundry_project.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    // Create
    public void addOrder(Order order){
        orderRepository.save(order);
    }

    // Read
    public List<Order> getOrderAll(){
        return orderRepository.getOrderAll();
    }


    // pageable 처리 전
    public List<Order> getOrderAllByClientCode(int clientCode){
        return orderRepository.getAllByClientCode(clientCode);
    }

    // pageable 처리 후
    public Page<Order> getOrderAllByClientCode(int clientCode, Pageable pageable){
        return orderRepository.getAllByClientCode(clientCode, pageable);
    }

    public Order getOrderByOrderCode(int orderCode){
        Order order = null;

        order = orderRepository.findById(orderCode).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 주문입니다.")
        );
        return order;
    }

    public List<Order> getOrderByStatusCode(int code) {
        return orderRepository.getOrderByOrderstatusCategoryCode(code);
    }

    // Update
    @Transactional
    public void updateOrderByOrderCode(@RequestBody Order order){
        Order modifyOrder = getOrderByOrderCode(order.getOrderCode());

        if( modifyOrder != null){
            modifyOrder.setOrder(order);
        }
    }

    @Transactional
    public void updateStatusByOrderCode(int statusCode, int orderCode){
        orderRepository.updateStatusByOrderCode(statusCode, orderCode);
    }

    @Transactional
    public void updatePaymentDateByOrderCode(int orderCode){
        orderRepository.updatePaymentDateByOrderCode(orderCode);
    }

    @Transactional
    public void updateIsWrittenByOrderCode(int orderCode){
        orderRepository.updateIsWrittenByOrderCode(orderCode);
    }

    // Delete
    @Transactional
    public void deleteOrderByOrderCode(@RequestParam int orderCode){
        Order removeOrder = getOrderByOrderCode(orderCode);

        if( removeOrder != null){
            orderRepository.deleteById(removeOrder.getOrderCode());
        }
    }
}
