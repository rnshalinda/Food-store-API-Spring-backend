package edu.icet.test.service.impl;

import edu.icet.test.model.dto.FoodItem;
import edu.icet.test.model.dto.Order;
import edu.icet.test.model.entity.FoodItemEntity;
import edu.icet.test.model.entity.OrderEntity;
import edu.icet.test.repository.FoodItemRepository;
import edu.icet.test.repository.OrderRepository;
import edu.icet.test.util.exception.CustomDbException;
import jakarta.persistence.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository repository;

    public List<Order> getAllOrders() {
        try {
            List<Order> orderList = new ArrayList<>();
            List<OrderEntity> entities = repository.findAll();

            if (!entities.isEmpty()) {
                for (OrderEntity entity : entities) {
                    orderList.add(
                            Order.builder()
                                    .OrderId(entity.getOrderId())
                                    .orderQty(entity.getOrderQty())
                                    .itemCode(entity.getItemCode())
                                    .discount(entity.getDiscount())
                                    .price(entity.getPrice())
                                    .build()
                    );
                }
                return orderList;
            }
            else {
                throw new CustomDbException("No data in foods table");
            }
        }catch(DataAccessException e){
            throw new PersistenceException("A database access error occurred:", e);
        }

    }


    public String addNewOrder(Order order) {

        try {
            Optional<OrderEntity> foundEntity = repository.findById(order.getOrderId());
            if (foundEntity.isPresent()) {
                return "Order Id: " + order.getOrderId() + ", Already exist!";
            } else {
                repository.save(
                        new OrderEntity(
                                order.getOrderId(), order.getItemCode(), order.getOrderQty(), order.getDiscount(), order.getPrice()
                        )
                );
                return "New Order saved successfully!";

            }
        } catch (DataAccessException e) {
            throw new PersistenceException("A database access error occurred:", e);
        }
    }

    public String updateOrder(Order order) {
        try {
            Optional<OrderEntity> foundEntity = repository.findById(order.getOrderId());
            if (foundEntity.isPresent()) {

                foundEntity.get().setOrderQty(order.getOrderQty());
                foundEntity.get().setItemCode(order.getItemCode());
                foundEntity.get().setDiscount(order.getDiscount());
                foundEntity.get().setDiscount(order.getDiscount());
                foundEntity.get().setPrice(order.getPrice());

                repository.save(foundEntity.get());

                return "Food item code: " + order.getOrderId() + ", details updated.";
            } else {
                return "Food item code: " + order.getOrderId() + ", Not found.";
            }
        } catch (DataAccessException e) {
            throw new PersistenceException("A database access error occurred:", e);
        }
    }

    public String deleteOrder(String id) {
        try {
            Optional<OrderEntity> foundEntity = repository.findById(id);

            if (foundEntity.isPresent()) {
                repository.delete(foundEntity.get());
                return "Order ID: " + id + ", Deleted successfully.";
            } else {
                return "Order ID: " + id + ", Not found.";
            }
        } catch (DataAccessException e) {
            throw new PersistenceException("A database access error occurred:", e);
        }

    }
}
