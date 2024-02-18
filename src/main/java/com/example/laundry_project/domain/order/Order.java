package com.example.laundry_project.domain.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
@Entity
public class Order {

    @Id
    private int orderCode;
    private int clientCode;
    private int orderstatusCategoryCode;
    private boolean orderReviewIsWritten;
    private Timestamp orderOrderDate;
    private Timestamp orderPaymentDate;
    private Timestamp orderCollectionDate;
    private Timestamp orderDeliveryDate;

    public Order(OrderRequestDto orderDto) {
        this.orderCode = orderDto.getOrderCode();
        this.clientCode = orderDto.getClientCode();
        this.orderstatusCategoryCode = orderDto.getOrderstatusCategoryCode();
        this.orderReviewIsWritten = orderDto.isOrderReviewIsWritten();
        this.orderOrderDate = orderDto.getOrderOrderDate();
        this.orderPaymentDate = orderDto.getOrderPaymentDate();
        this.orderCollectionDate = orderDto.getOrderCollectionDate();
        this.orderDeliveryDate = orderDto.getOrderDeliveryDate();
    }

    public void setOrder(Order order) {
        this.orderstatusCategoryCode = order.getOrderstatusCategoryCode();
        this.orderReviewIsWritten = order.isOrderReviewIsWritten();
        this.orderPaymentDate = order.getOrderPaymentDate();
        this.orderCollectionDate = order.getOrderCollectionDate();
        this.orderDeliveryDate = order.getOrderDeliveryDate();
    }

}
