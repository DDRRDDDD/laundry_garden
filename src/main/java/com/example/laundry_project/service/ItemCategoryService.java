package com.example.laundry_project.service;

import com.example.laundry_project.domain.itemcategory.ItemCategory;
import com.example.laundry_project.repository.ItemCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemCategoryService {

    private final ItemCategoryRepository itemCategoryRepository;

    // Create
    public void addItemCategory(ItemCategory itemCategory) {
        itemCategoryRepository.save(itemCategory);
    }

    // Read
    public List<ItemCategory> getItemCategoryAll() {
        return itemCategoryRepository.findAll();
    }

    public List<ItemCategory> getAllByCategoryCode(int categoryCode){
        return itemCategoryRepository.getAllByItemCategoryCode(categoryCode);
    }

    public ItemCategory getItemCategoryByCode(int code) {
        ItemCategory itemCategory = null;

        itemCategory = itemCategoryRepository.findById(code).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 세탁물 대분류 카테고리 입니다.")
        );
        return itemCategory;
    }

    // Update
    @Transactional
    public void updateItemCategoryByCode(ItemCategory itemCategory) {
        ItemCategory category = getItemCategoryByCode(itemCategory.getItemCategoryCode());

        if (category != null) {
            category.setItemCategory(itemCategory);
        }
    }

    // Delete
    @Transactional // 문제 발생시 자동 롤백
    public void deleteItemCategoryByCode(int code) {
        ItemCategory category = getItemCategoryByCode(code);

        if (category != null) {
            itemCategoryRepository.deleteById(category.getItemCategoryCode());
        }
    }
}
