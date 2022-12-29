package ru.baster.spring.shop.models;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Integer price;

}
