package edu.icet.test.model.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @Id
    @Column(length = 6, nullable = false)
    private String code;

    @Column(length = 50, nullable = false)
    private String description;

    @Column(length = 20, nullable = true)
    private String size;

    @Column(precision = 10, nullable = false)
    private double unitPrice;

    @Column(nullable = false)
    private int qty;
}
