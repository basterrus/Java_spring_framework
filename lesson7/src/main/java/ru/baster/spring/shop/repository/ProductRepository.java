package ru.baster.spring.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.baster.spring.shop.models.Product;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByPriceGreaterThanEqual(int minPrice);
    List<Product> findAllByIdLessThanEqual(Long maxId);
    List<Product> findAllByIdBetweenAndPriceGreaterThan(Long minId, Long maxId, int minPrice);
}
