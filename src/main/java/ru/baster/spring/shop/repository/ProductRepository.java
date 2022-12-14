package ru.baster.spring.shop.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import ru.baster.spring.shop.exeptions.NotFoundProductException;
import ru.baster.spring.shop.models.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> lines;

    @PostConstruct
    public void initProducts () {
        this.lines = new ArrayList<>(List.of(
                new Product(1L, "Milk", 100),
                new Product(2L, "Better", 130),
                new Product(3L, "Egg", 120),
                new Product(4L, "Rise", 110),
                new Product(5L, "Potato", 100),
                new Product(6L, "Beer", 100),
                new Product(7L, "Pasta", 100),
                new Product(8L, "Apple", 100),
                new Product(9L, "Orange", 100),
                new Product(10L, "Watermelon", 100)
        ));
    }
    public List<Product> getAllLines(){
        return Collections.unmodifiableList(lines);
    }
    public void add(Product product) {
        product.setId(lines.stream().mapToLong(Product::getId).max().getAsLong() + 1L);
        lines.add(product);
    }

    public Product findById(Long id) {
        for (Product p : lines) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        throw new NotFoundProductException();
    }
}


