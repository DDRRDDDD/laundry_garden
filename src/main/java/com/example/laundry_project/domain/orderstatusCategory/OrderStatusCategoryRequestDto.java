package com.example.laundry_project.domain.orderstatusCategory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OrderStatusCategoryRequestDto {

    private int orderstatusCategoryCode;
    private String orderstatusCategoryKind;
}
