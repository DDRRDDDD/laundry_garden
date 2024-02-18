package com.example.laundry_project.domain.item;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ItemRequestDto {

    private int itemCode;
    private int itemCategoryCode;
    private String itemName;
    private int itemPrice;

}
