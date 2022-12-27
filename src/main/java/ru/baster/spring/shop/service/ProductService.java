package ru.baster.spring.shop.service;

import org.springframework.stereotype.Service;
import ru.baster.spring.shop.models.Product;
import ru.baster.spring.shop.ProductRepository;

import java.util.Collections;
import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProductList() {
        return Collections.unmodifiableList(productRepository.findAll());
    }

    public void deleteProductById(Long id) {
        productRepository.deleteProductById(id);
    }

    public Object findById(Long id) {
        productRepository.findById(id);
        return null;
    }

    public void saveOrUpdate(String title, String price) {
        productRepository.saveOrUpdate(title, price);
    }

}
