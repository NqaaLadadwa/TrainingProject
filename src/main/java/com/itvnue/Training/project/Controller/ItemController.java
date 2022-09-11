package com.itvnue.Training.project.Controller;

import com.itvnue.Training.project.Controller.dto.ItemDto;
import com.itvnue.Training.project.Models.Item;
import org.springframework.web.bind.annotation.*;
import com.itvnue.Training.project.Controller.dto.ItemDto;
import com.itvnue.Training.project.Models.Attachment;
import com.itvnue.Training.project.Models.Invoice;
import com.itvnue.Training.project.Models.Item;
import com.itvnue.Training.project.Service.InvoiceService;
import com.itvnue.Training.project.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/item")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }


    @GetMapping
    public List<Item> getItems() {
        return itemService.getItems();
    }
 /*   @GetMapping
    public ResponseEntity<Item> getItemById(@PathVariable("id") Integer itemId){
        return new ResponseEntity<Item>(itemService.getItemById(itemId), HttpStatus.OK)
    }*/

    @PostMapping
    public void addNewItem(@RequestBody ItemDto itemDto){
        itemService.addNewItem(itemDto);
    }

    @DeleteMapping(path = "{itemId}")
    public void deleteItem(@PathVariable("itemId") int itemId){
        itemService.deleteItem(itemId);
    }

    @PutMapping(path = "{itemId}")
    public void updateItem(@RequestBody Item item){

        itemService.updateItem(item);

    }
}
