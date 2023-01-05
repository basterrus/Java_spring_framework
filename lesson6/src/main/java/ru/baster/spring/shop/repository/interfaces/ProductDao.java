package ru.baster.spring.shop.repository.interfaces;

import org.springframework.stereotype.Component;
import ru.baster.spring.shop.models.Product;

import java.util.List;


@Component
public interface ProductDao {

    Product findById (Long id);
    List<Product> findAll();
    void deleteById(Long id);
    Product saveOrUpdate(Product product);
}
