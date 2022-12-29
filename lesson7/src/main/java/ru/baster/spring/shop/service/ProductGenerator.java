package ru.baster.spring.shop.service;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.baster.spring.shop.models.Product;
import ru.baster.spring.shop.repository.ProductRepository;

@Component
public class ProductGenerator {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private Faker faker;

    @EventListener(ApplicationReadyEvent.class)
    public void generateProductData() {
        for (int i=0; i <20; i++) {
            Product product = new Product();
            product.setName(faker.name().name());
            product.setPrice(faker.number().numberBetween(10, 90));
            productRepository.save(product);
        }
    }
}
