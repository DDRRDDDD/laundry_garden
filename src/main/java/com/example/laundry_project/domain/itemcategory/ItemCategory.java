package com.example.laundry_project.domain.itemcategory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "item_category")
@Entity
public class ItemCategory {

    @Id
    private int itemCategoryCode;
    private String itemCategoryKind;
    private String itemCategoryInfo;

    public ItemCategory(ItemCategoryRequestDto itemCategoryRequestDto) {
        this.itemCategoryCode = itemCategoryRequestDto.getItemCategoryCode();
        this.itemCategoryKind = itemCategoryRequestDto.getItemCategoryKind();
        this.itemCategoryInfo = itemCategoryRequestDto.getItemCategoryInfo();
    }

    public void setItemCategory(ItemCategory itemCategory) {
        this.itemCategoryKind = itemCategory.getItemCategoryKind();
        this.itemCategoryInfo = itemCategory.getItemCategoryInfo();
    }
}
