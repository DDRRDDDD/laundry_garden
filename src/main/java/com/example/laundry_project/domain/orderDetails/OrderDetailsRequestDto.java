package com.example.laundry_project.domain.orderDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OrderDetailsRequestDto {

    private int orderDetailsCode;
    private int orderCode;
    private int itemCode;
    private int orderDetailsAmount;
    private int orderDetailsPrice;

}
