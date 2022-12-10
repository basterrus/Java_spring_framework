package ru.baster.spring.shop.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.baster.spring.shop.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Cart {
    private ProductService productService;
    private List<Product> productList = new ArrayList<>();

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public void putProduct(long id) {
        productList.add(productService.getProduct(id));
    }

    public void deleteProduct(long id) {
        productList.removeIf(p -> p.getId() == id);
    }

    @Override
    public String toString() {

        if (productList.isEmpty()) {
            return "Корзина пуста";
        }

        StringBuilder str = new StringBuilder();
        for (Product p : productList) {
            str.append(p).append("\n");
        }
        return str.toString();

    }
}