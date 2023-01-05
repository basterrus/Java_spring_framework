package ru.baster.spring.shop.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.baster.spring.shop.models.Product;
import ru.baster.spring.shop.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public List<Product> getAllProduct() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("")
    public String addProduct(@RequestParam String name, @RequestParam Integer price) {
        productService.saveProduct(name, price);
        return "OK";
    }

    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable Long id) {
        productService.deleteById(id);
        return "Ok";
    }

    @GetMapping("/find_min_price")
    public List<Product> findByMinPrice(@RequestParam(name = "min") int min) {
        return productService.findByMinPrice(min);
    }

}
