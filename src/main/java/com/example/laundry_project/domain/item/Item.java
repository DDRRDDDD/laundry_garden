package com.example.laundry_project.domain.item;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "item")
@Entity
public class Item {

    @Id
    private int itemCode;
    private int itemCategoryCode;
    private String itemName;
    private int itemPrice;

    public Item(ItemRequestDto itemDto) {
        this.itemCode = itemDto.getItemCode();
        this.itemCategoryCode = itemDto.getItemCategoryCode();
        this.itemName = itemDto.getItemName();
        this.itemPrice = itemDto.getItemPrice();
    }

    public void setItem(Item item) {
        this.itemCategoryCode = item.getItemCategoryCode();
        this.itemName = item.getItemName();
        this.itemPrice = item.getItemPrice();
    }

}
