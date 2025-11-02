package edu.icet.test.controller;

import edu.icet.test.model.dto.FoodItem;
import edu.icet.test.service.impl.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/item")
public class FoodItemController {

    @Autowired
    FoodItemService service;


    @GetMapping("/all")
    public List<FoodItem> getAllItems(){
        return service.getAllFoods();
    }



}
