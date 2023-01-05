package ru.baster.spring.lesson5.dao;

import org.springframework.stereotype.Component;
import ru.baster.spring.lesson5.models.Product;

import java.util.List;

@Component
public interface ProductDao {

    Product findById (Long id);
    List<Product> findAll();
    void deleteById(Long id);
    Product saveOrUpdate(Product product);

}
