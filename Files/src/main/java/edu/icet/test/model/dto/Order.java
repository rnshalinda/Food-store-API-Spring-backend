package edu.icet.test.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Builder
public class Order {

    private String OrderId;

    private Long itemCode;

    private int orderQty;

    private double discount;

    private double price;

}
