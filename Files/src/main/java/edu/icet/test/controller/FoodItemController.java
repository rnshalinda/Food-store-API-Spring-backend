package edu.icet.test.controller;

import edu.icet.test.model.dto.FoodItem;
import edu.icet.test.service.impl.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Food")
public class FoodItemController {

    @Autowired
    FoodItemService service;


    @GetMapping("/all")
    public List<FoodItem> getAllItems(){
        return service.getAllFoods();
    }

    @PostMapping("/new")
    public String addNewItem(@RequestBody FoodItem item){
        return service.addNewFoodItem(item);
    }

    @PutMapping("/update")
    public String updateFoodItem(@RequestBody FoodItem item) {
        return service.updateFoodItem(item);
    }


    @DeleteMapping("/delete/{code}")
    public String deleteFoodItem(@PathVariable Long code) {
        return service.deleteFoodItem(code);
    }

}
