package edu.icet.test.service.impl;

import edu.icet.test.model.dto.FoodItem;
import edu.icet.test.model.entity.FoodItemEntity;
import edu.icet.test.repository.FoodItemRepository;
import edu.icet.test.util.exception.CustomDbException;
import jakarta.persistence.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FoodItemService {

    @Autowired
    FoodItemRepository repository;

    public List<FoodItem> getAllFoods() {
        try {
            List<FoodItem> food = new ArrayList<>();
            List<FoodItemEntity> entities = repository.findAll();

            if (!entities.isEmpty()) {
                for (FoodItemEntity entity : entities) {
                    food.add(
                            FoodItem.builder()
                                    .code(entity.getCode())
                                    .description(entity.getDescription())
                                    .size(entity.getSize())
                                    .unitPrice(entity.getUnitPrice())
                                    .qty(entity.getQty())
                                    .build()
                    );
                }
                return food;
            }
            else {
                throw new CustomDbException("No data in foods table");
            }
        }catch(DataAccessException e){
            throw new PersistenceException("A database access error occurred:", e);
        }

    }


    public String addNewFoodItem(FoodItem item) {

        try {
            Optional<FoodItemEntity> foundEntity = repository.findById(item.getCode());
            if (foundEntity.isPresent()) {
                return "Item code: " + item.getCode() + ", Already exist!";
            } else {
                repository.save(
                        new FoodItemEntity(
                                item.getCode(), item.getDescription(), item.getUnitPrice(), item.getSize(), item.getQty()
                        )
                );
                return "New Food item saved successfully!";
            }
        } catch (DataAccessException e) {
            throw new PersistenceException("A database access error occurred:", e);
        }
    }

    public String updateFoodItem(FoodItem item) {
        try {
            Optional<FoodItemEntity> foundEntity = repository.findById(item.getCode());
            if (foundEntity.isPresent()) {

                foundEntity.get().setDescription(item.getDescription());
                foundEntity.get().setUnitPrice(item.getUnitPrice());
                foundEntity.get().setSize(item.getSize());
                foundEntity.get().setQty(item.getQty());

                repository.save(foundEntity.get());

                return "Food item code: " + item.getCode() + ", details updated.";
            } else {
                return "Food item code: " + item.getCode() + ", Not found.";
            }
        } catch (DataAccessException e) {
            throw new PersistenceException("A database access error occurred:", e);
        }
    }

    public String deleteFoodItem(Long id) {
        try {
            Optional<FoodItemEntity> foundEntity = repository.findById(id);

            if (foundEntity.isPresent()) {
                repository.delete(foundEntity.get());
                return "Food item code: " + id + ", Deleted successfully.";
            } else {
                return "Food item code: " + id + ", Not found.";
            }
        } catch (DataAccessException e) {
            throw new PersistenceException("A database access error occurred:", e);
        }

    }
}
