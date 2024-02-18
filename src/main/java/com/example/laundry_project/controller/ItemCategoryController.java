package com.example.laundry_project.controller;

import com.example.laundry_project.domain.itemcategory.ItemCategory;
import com.example.laundry_project.domain.itemcategory.ItemCategoryRequestDto;
import com.example.laundry_project.service.ItemCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// 구분 Mapping
@RequestMapping("itemcategory")
@RequiredArgsConstructor
@RestController
public class ItemCategoryController {

    private final ItemCategoryService itemCategoryService;

    @PostMapping("create")
    public ItemCategory addCategory(@RequestBody ItemCategoryRequestDto itemcategoryDto) {
        ItemCategory category = new ItemCategory(itemcategoryDto);
        itemCategoryService.addItemCategory(category);
        return category;
    }

    @PostMapping("searchall")
    public List<ItemCategory> getItemCategoryAll() {
        List<ItemCategory> list = itemCategoryService.getItemCategoryAll();
        return list;
    }

    @PostMapping("searchallcategory")
    public List<ItemCategory> getAllByCategoryCode(int categoryCode) {
        List<ItemCategory> list = itemCategoryService.getAllByCategoryCode(categoryCode);
        return list;
    }


    @PostMapping("searchone")
    public ItemCategory getItemCategoryByCode(int code) {
        return itemCategoryService.getItemCategoryByCode(code);
    }

    @PutMapping("update")
    public void updateItemCategoryByCode(@RequestBody ItemCategoryRequestDto itemcategoryDto) {
        ItemCategory itemCategory = new ItemCategory(itemcategoryDto);
        itemCategoryService.updateItemCategoryByCode(itemCategory);
    }

    @DeleteMapping("remove")
    public void deleteItemCategoryByCode(@RequestParam int code) {
        itemCategoryService.deleteItemCategoryByCode(code);
    }

}
