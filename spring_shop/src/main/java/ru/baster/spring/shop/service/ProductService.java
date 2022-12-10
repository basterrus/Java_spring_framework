package ru.baster.spring.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.baster.spring.shop.entities.Product;
import ru.baster.spring.shop.repository.ProductRepository;

import java.util.List;

@Component
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProductList(){
        return productRepository.getProductList();
    }

    public Product getProduct(long id){
        return productRepository.getProduct(id);
    }

}