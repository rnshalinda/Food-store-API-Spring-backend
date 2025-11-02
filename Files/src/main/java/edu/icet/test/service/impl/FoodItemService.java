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
}
