package edu.icet.test.controller;

import edu.icet.test.model.dto.Customer;
import edu.icet.test.model.dto.FoodItem;
import edu.icet.test.service.impl.CustomerService;
import edu.icet.test.service.impl.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService service;


    @GetMapping("/all")
    public List<Customer> getAllCustomers(){
        return service.getAllCustomers();
    }

    @PostMapping("/new")
    public String addNewCustomer(@RequestBody Customer customer){
        return service.addNewCustomer(customer);
    }

    @PutMapping("/update")
    public String updateCustomer(@RequestBody Customer customer) {
        return service.updateCustomer(customer);
    }


    @DeleteMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable String id) {
        return service.deleteCustomer(id);
    }

}
