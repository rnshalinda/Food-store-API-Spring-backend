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

@Table(name = "Order")
@Entity
public class OrderEntity {

    @Id
    @Column(length = 5)
    private String orderID;

    @Column(length = 6)
    private String itemCode;

    @Column(nullable = false)
    private int orderQTY;

    @Column(precision = 3)
    private double discount;
}
