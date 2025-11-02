package edu.icet.test.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEntity {


    @Id
    @Column(length = 5, nullable = false)
    private String id;

    @Column(length = 10)
    private String name ;

    @Column(length = 10)
    private Integer phone;

    private String email;


}
