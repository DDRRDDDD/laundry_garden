package com.example.laundry_project.repository;

import com.example.laundry_project.domain.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {


    public List<Item> getAllByItemCategoryCode(int categoryCode);

}
