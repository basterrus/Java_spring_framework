package ru.baster.spring.shop.controllers;


import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.baster.spring.shop.repository.ProductRepository;

@Controller
public class ProductController {
    private ProductRepository productRepository;
    //  http://localhost:8080/products/

    @GetMapping("/products")
    public String showProjectList(Model model) {
        return productRepository.getLines().toString();
    }
}
