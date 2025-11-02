package edu.icet.test.controller;

import edu.icet.test.model.dto.Order;
import edu.icet.test.service.impl.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService service;


    @GetMapping("/all")
    public List<Order> getAllOrders(){
        return service.getAllOrders();
    }

    @PostMapping("/new")
    public String addNewOrder(@RequestBody Order order){
        return service.addNewOrder(order);
    }

    @PutMapping("/update")
    public String updateOrder(@RequestBody Order order) {
        return service.updateOrder(order);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteOrder(@PathVariable String id) {
        return service.deleteOrder(id);
    }

}
