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

@Table(name = "customer")
@Entity
public class CustomerEntity {

    @Id
    @Column(length = 5)
    private String id;

    @Column(length = 10)
    private String name ;

    @Column(length = 10)
    private Integer phone;

    private String email;


}
