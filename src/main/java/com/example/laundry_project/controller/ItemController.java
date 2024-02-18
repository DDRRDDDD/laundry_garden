package com.example.laundry_project.controller;

import com.example.laundry_project.domain.item.Item;
import com.example.laundry_project.domain.item.ItemRequestDto;
import com.example.laundry_project.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("item")
@RequiredArgsConstructor
@RestController
public class ItemController {

    private final ItemService itemService;

    @PostMapping("create")
    public Item addItem(@RequestBody ItemRequestDto itemDto) {
        Item item = new Item(itemDto);
        itemService.addItem(item);
        return item;
    }

    @PostMapping ("searchall")
    public List<Item> getItemAll() {
        List<Item> list = itemService.getItemAll();
        return list;
    }

    @PostMapping("searchallcategory")
    public List<Item> getItemAllByCategoryCode(int categoryCode) {
        List<Item> list = itemService.getItemAllByCategory(categoryCode);
        return list;
    }

    @PostMapping("searchone")
    public Item getItemByCode(int code) {
        return itemService.getItemByCode(code);
    }

    @PutMapping("update")
    public void updateItemByCode(@RequestBody ItemRequestDto itemDto) {
        Item item = new Item(itemDto);
        itemService.updateItemByCode(item);
    }

    @DeleteMapping("remove")
    public void deleteItemByCode(@RequestParam int code) {
        itemService.deleteItemByCode(code);
    }

}
