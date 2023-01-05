package ru.baster.spring.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.baster.spring.shop.models.Product;
import ru.baster.spring.shop.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public String saveProduct(String name, int price) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        if (product.getPrice() <= 0) {
            return name;
        }
        productRepository.save(product);
        return name;
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product>findByMinPrice(int minPrice) {
        return productRepository.findAllByPriceGreaterThanEqual(minPrice);
    }


}
