package edu.icet.test.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderEntity {

    @Id
    @Column(length = 6, nullable = false)
    private String orderID;

    @Id
    @Column(length = 6, nullable = false)
    private String itemCode;

    @Column(nullable = false)
    private int orderQTY;

    @Column(precision = 3)
    private double discount;
}
