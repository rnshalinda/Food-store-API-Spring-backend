package edu.icet.test.model.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor

@Builder
public class Customer {

    @Id
    @Column(length = 5)
    private String id;

    @Column(length = 10)
    private String name ;

    @Column(length = 10)
    private Integer phone;

    private String email;


}
