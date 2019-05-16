package mksnkv.nets.controllers;

import mksnkv.nets.entities.Items;
import mksnkv.nets.repos.ItemsRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class EntitiesController {
    private final ItemsRepo itemsRepo;

    @Autowired
    public EntitiesController(ItemsRepo itemsRepo) {
        this.itemsRepo = itemsRepo;
    }

    @GetMapping("/items")
    public List<Items> list() {
        return itemsRepo.findAll();
    }

    @PostMapping("/items")
    public Items create(@RequestBody Items items) {
        return itemsRepo.save(items);
    }

    @PutMapping("/items{id}")
    public Items update(@PathVariable("id") Items itemsFromDB,
                        @RequestBody Items items) {
        BeanUtils.copyProperties(items, itemsFromDB, "id");
        return itemsRepo.save(itemsFromDB);
    }

    @DeleteMapping("/items{id}")
    public void delete(@PathVariable("id") Items items) {
        itemsRepo.delete(items);
    }
}
