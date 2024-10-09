package com.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "fruits")
public class Fruits {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "fruit_name", unique = true)
    private String fruit_name;

    @Column(name = "fruit_price")
    private String fruit_price;

    @Column(name = "fruit_quantity")
    private String fruit_quantity;

}