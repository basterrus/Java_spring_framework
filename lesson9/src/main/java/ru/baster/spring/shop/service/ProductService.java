package ru.baster.spring.shop.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.baster.spring.shop.models.Product;
import ru.baster.spring.shop.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository productRepository;

    public Page<Product> findAll(Specification<Product> spec, Integer numPage, int sizePage){
        return productRepository.findAll(spec, PageRequest.of(numPage, sizePage));
    }

    public Optional<Product> findById(Long id){
        return productRepository.findById(id);
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public void deleteById(Long id){
        productRepository.deleteById(id);
    }


}
