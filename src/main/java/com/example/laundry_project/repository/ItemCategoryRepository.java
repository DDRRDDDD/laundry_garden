package com.example.laundry_project.repository;

import com.example.laundry_project.domain.itemcategory.ItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemCategoryRepository extends JpaRepository<ItemCategory, Integer> {


    public List<ItemCategory> getAllByItemCategoryCode(int categoryCode);
}
