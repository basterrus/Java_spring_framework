package ru.baster.spring.shop.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.baster.spring.shop.model.Product;
import ru.baster.spring.shop.services.ProductService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public String showMainPage(Model model) {
        model.addAttribute("items", productService.findAll());
        return "index";
    }

    @GetMapping("/products/add")
    public String showAddProductForm() {
        return "add_product_form";
    }

    @PostMapping("/products/add")
    public String saveNewProduct(@RequestParam String title, @RequestParam int price) {
        productService.saveNewProduct(title, price);
        return "redirect:/";
    }

    @GetMapping ("/products/{id}")
    public String showProductInfo(Model model, @PathVariable Long id) {
        model.addAttribute("product", productService.findById(id));
        return "product_info";
    }

    @GetMapping("/products/find_by_price")
    @ResponseBody
    public List<Product> findByMinPrice(@RequestParam(name = "min") int min) {
        return productService.findByMinPrice(min);
    }
}
