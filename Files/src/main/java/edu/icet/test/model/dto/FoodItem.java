package edu.icet.test.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FoodItem {

    private Long code;

    private String description;

    private double unitPrice;

    private String size;

    private int qty;
}
