package ru.baster.spring.shop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.baster.spring.shop.service.ProductService;

@Controller
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String showMainPage(Model model) {
        model.addAttribute("items", productService.getProductList());
        return "product/products";
    }
    @GetMapping("/products/add")
    public String showAddProductForm() {
        return "product/add_form";
    }

    @PostMapping("/products/add")
    public String saveNewProduct(@RequestParam String title, @RequestParam int price) {
        productService.saveOrUpdate(title, String.valueOf(price));
        return "redirect:/";
    }

    @GetMapping ("/products/{id}")
    public String showProductInfo(Model model, @PathVariable Long id) {
        model.addAttribute("product", productService.findById(id));
        return "product/product_info";
    }

    @GetMapping("/products/delete/{id}")
    public void deleteProductById(@PathVariable Long id){
        productService.deleteProductById(id);
    }

}
