package com.example.laundry_project.domain.itemcategory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ItemCategoryRequestDto {

    private int itemCategoryCode;
    private String itemCategoryKind;
    private String itemCategoryInfo;
}
