package com.example.laundry_project.domain.orderView;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Builder
@Getter
@Setter
public class OrderViewDto {
    private int orderCode;
    private int clientCode;
    private Timestamp orderCollectionDate;
    private int orderstatusCategoryCode;
}
