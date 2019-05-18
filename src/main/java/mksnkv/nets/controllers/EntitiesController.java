package mksnkv.nets.controllers;

import mksnkv.nets.entities.Items;
import mksnkv.nets.repos.ItemsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
