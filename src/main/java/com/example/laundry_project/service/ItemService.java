package com.example.laundry_project.service;


import com.example.laundry_project.domain.item.Item;
import com.example.laundry_project.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    // Create
    public void addItem(Item item){
        itemRepository.save(item);
    }

    // Read
    public List<Item> getItemAll(){
        return itemRepository.findAll();
    }

    public List<Item> getItemAllByCategory(int categoryCode){
        return itemRepository.getAllByItemCategoryCode(categoryCode);
    }

    public Item getItemByCode(int code){
        Item item = null;

        item = itemRepository.findById(code).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 세탁항목입니다.")
        );
        return item;
    }

    // Update
    @Transactional
    public void updateItemByCode(Item item){
        Item newItem = getItemByCode(item.getItemCode());

        if( newItem != null){
            newItem.setItem(newItem);
        }
    }

    // Delete
    @Transactional
    public void deleteItemByCode(int code){
        Item removeItem = getItemByCode(code);

        if( removeItem != null){
            itemRepository.deleteById(removeItem.getItemCode());
        }
    }

}
