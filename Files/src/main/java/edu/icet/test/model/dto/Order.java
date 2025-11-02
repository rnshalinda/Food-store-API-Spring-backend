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
public class Order {

    @Id
    @Column(length = 5)
    private String orderID;

    @Id
    @Column(length = 5)
    private String itemCode;

    @Column(nullable = false)
    private int orderQTY;

    @Column(precision = 3)
    private double discount;
}
