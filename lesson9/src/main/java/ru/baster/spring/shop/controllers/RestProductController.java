package ru.baster.spring.shop.controllers;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.baster.spring.shop.exception.ResourceNotFoundException;
import ru.baster.spring.shop.models.Product;
import ru.baster.spring.shop.repository.filters.ProductFilter;
import ru.baster.spring.shop.service.ProductService;

import java.util.Map;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class RestProductController {

    private static final int PAGE_SIZE = 20;
    private ProductService productService;

    @GetMapping
    public Page<Product> productsList(@RequestParam(name = "p", required = false, defaultValue = "1") Integer numPage,
        @RequestParam Map<String, String> params){
        if(numPage <= 0){
            numPage = 1;
        }

        ProductFilter productFilter = new ProductFilter(params);
        return productService.findAll(productFilter.getSpec(), numPage-1, PAGE_SIZE);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.findById(id).orElseThrow(()-> new ResourceNotFoundException("No data"));
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productService.save(product);
    }

    @PutMapping
    public Product updateProduct(@RequestBody Product product){
        return productService.save(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteById(id);
    }

}
