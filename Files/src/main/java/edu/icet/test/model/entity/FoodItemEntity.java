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
    @Column(length = 6)
    private Long code;

    @Column(length = 50)
    private String description;

    @Column(length = 20)
    private String size;

    @Column(precision = 10)
    private double unitPrice;

    @Column(length = 10)
    private int qty;
}
