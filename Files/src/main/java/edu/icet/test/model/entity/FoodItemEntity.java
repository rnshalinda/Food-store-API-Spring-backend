package edu.icet.test.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "food")
@Entity
public class FoodItemEntity {

    @Id
    private Long code;

    private String description;

    private double unitPrice;

    private String size;

    private int qty;
}
