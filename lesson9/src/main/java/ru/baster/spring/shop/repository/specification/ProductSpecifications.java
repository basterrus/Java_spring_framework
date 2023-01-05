package ru.baster.spring.shop.repository.specification;

import org.springframework.data.jpa.domain.Specification;
import ru.baster.spring.shop.models.Product;

import java.math.BigDecimal;

public class ProductSpecifications {
    public static Specification<Product> priceGreaterOrEqualsThan(int minPrice){
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice);
    }

    public static Specification<Product> priceLesserOrEqualsThan(int maxPrice){
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice);
    }

    public static Specification<Product> titleLike(String titlePart){
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), String.format("%%%s%%", titlePart));
    }

}