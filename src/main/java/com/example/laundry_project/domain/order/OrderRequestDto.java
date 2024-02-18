package com.example.laundry_project.domain.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
public class OrderRequestDto {

    private int orderCode;
    private int clientCode;
    private int orderstatusCategoryCode;
    private boolean orderReviewIsWritten;
    private Timestamp orderOrderDate;
    private Timestamp orderPaymentDate;
    private Timestamp orderCollectionDate;
    private Timestamp orderDeliveryDate;

}
