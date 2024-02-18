package com.example.laundry_project.domain.orderDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_details")
@Entity
public class OrderDetails {
    @Id
    private int orderDetailsCode;
    private int orderCode;
    private int itemCode;
    private int orderDetailsAmount;
    private int orderDetailsPrice;

    public OrderDetails(OrderDetailsRequestDto orderDetailsRequestDto) {
        this.orderDetailsCode = orderDetailsRequestDto.getOrderDetailsCode();
        this.orderCode = orderDetailsRequestDto.getOrderCode();
        this.itemCode = orderDetailsRequestDto.getItemCode();
        this.orderDetailsAmount = orderDetailsRequestDto.getOrderDetailsAmount();
        this.orderDetailsPrice = orderDetailsRequestDto.getOrderDetailsPrice();
    }
}
