package com.example.laundry_project.domain.orderdetailshistory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_details_history")
@Entity
public class OrderDetailsHistory {

    @Id
    private int orderDetailsCode;

    private int orderCode;
    private String itemCategoryKind;
    private String itemName;
    private int itemPrice;
    private int orderDetailsAmount;
    private int subtotal;
}
