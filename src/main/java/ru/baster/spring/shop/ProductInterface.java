package ru.baster.spring.shop;

import org.springframework.stereotype.Service;
import ru.baster.spring.shop.models.Product;

import java.util.List;

@Service
public interface ProductInterface {
    Product findById(Long id);

    List<Product> findAll();

    void deleteProductById(Long id);

    Product saveOrUpdate(String title, String price);
}
