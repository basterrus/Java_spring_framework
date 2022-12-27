package ru.baster.spring.lesson5.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.baster.spring.lesson5.services.ProductService;
import ru.baster.spring.lesson5.models.Product;

import java.util.List;

@Controller
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getProducts () {
        return productService.getProducts();
    }

    @GetMapping("/product/del/{id}")
    public void delProduct (@PathVariable Long id) {
        System.out.println(id);
        productService.delById(id);
    }

    @GetMapping("/product/change_cost")
    public void changeCost (@RequestParam Long productId, @RequestParam Integer delta) {
        productService.changeCost(productId, delta);
    }
}
