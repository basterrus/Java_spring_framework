package ru.baster.spring.shop.entities;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Product {

    private Long id;
    private String title;
    private Integer price;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }


    public Product(Long id, String title, Integer price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Product [id = %d, title = '%s', price=%d]", id, title, price);
    }
}
