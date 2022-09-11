package com.itvnue.Training.project.Service;

import com.itvnue.Training.project.Controller.dto.ItemDto;
import com.itvnue.Training.project.Models.Item;
import com.itvnue.Training.project.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    @PostMapping("all/")
    public void addNewItem(ItemDto itemDto) {
        Item item = new Item();
        item.setId(itemDto.getId());
        item.setDescription(itemDto.getDescription());
        item.setPrice(itemDto.getPrice());
        itemRepository.save(item);

    }

    public void deleteItem(int itemId) {
        boolean exists =  itemRepository.existsById(itemId);
        if (!exists){
            throw new IllegalStateException("item with id" + itemId + "does not exist");
        }
        itemRepository.deleteById(itemId);
    }

    public Item updateItem(Item item){
        Optional<Item> itemOptional = itemRepository.findById(item.getId());
        //Check if the item is not existed (if not, add item)
        if (!itemOptional.isPresent()) {
            return itemRepository.save(item);

        }
        Item item1 = itemOptional.get();
        item1.setDescription(item.getDescription());
        item1.setPrice(item.getPrice());


        return itemRepository.save(item1);

    }
}
