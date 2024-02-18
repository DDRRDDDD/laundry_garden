package com.example.laundry_project.domain.orderstatusCategory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orderstatus_category")
@Entity
public class OrderStatusCategory {

    @Id
    private int orderstatusCategoryCode;
    private String orderstatusCategoryKind;

    public OrderStatusCategory(OrderStatusCategoryRequestDto orderstatusRequestDto) {
        this.orderstatusCategoryCode = orderstatusRequestDto.getOrderstatusCategoryCode();
        this.orderstatusCategoryKind = orderstatusRequestDto.getOrderstatusCategoryKind();
    }


}
