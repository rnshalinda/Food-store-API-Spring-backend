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

@Table(name = "orders")
@Entity
public class OrderEntity {

    @Id
    private String OrderId;

    private Long itemCode;

    private int orderQty;

    private double discount;

    private double price;
}
