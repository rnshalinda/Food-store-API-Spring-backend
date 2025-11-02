package edu.icet.test.model.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FoodItem {

    @Id
    @Column(length = 5)
    private Long code;

    @Column(length = 50, nullable = false)
    private String description;

    @Column(length = 20, nullable = true)
    private String size;

    @Column(precision = 10, nullable = false)
    private double unitPrice;

    @Column(nullable = false)
    private int qty;
}
