package ru.baster.spring.shop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.baster.spring.shop.configs.AppConfig;
import ru.baster.spring.shop.entities.Cart;
import ru.baster.spring.shop.entities.Product;
import ru.baster.spring.shop.repository.ProductRepository;
import ru.baster.spring.shop.service.ProductService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class MainClass {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProductService productService = context.getBean("productService", ProductService.class);

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.printf("command list: \n"
                    + "p_list - get all product items \n"
                    + "create - create user cart \n"
                    + "add - add product in cart \n"
                    + "del - delete product from cart \n"
                    + "c_list - get all items in cart \n"
                    + "exit - close app\n");

            String command = null;
            Cart cart = null;
            long temp = 01;


            while (true) {
                command = bufferedReader.readLine();

                if (command.equals("exit")) {
                    break;
                }

                if (command.equals("p_list")) {
                    List<Product> productList = productService.getProductList();
                    if (productList.isEmpty()) {
                        System.out.println("Product list is empty");
                    }

                    StringBuilder str = new StringBuilder();
                    for (Product p : productList) {
                        str.append(p).append("\n");
                    }
                    System.out.println(str.toString());
                }

                if (command.equals("create")) {
                    cart = context.getBean("cart", Cart.class);
                    System.out.println("Cart create");
                }

                if (cart != null) {
                    if (command.equals("c_list")) {
                        System.out.println(cart);
                    }

                    if (command.equals("add")) {
                        System.out.println("Enter product id");
                        temp = Long.parseLong(bufferedReader.readLine());
                        try {
                            cart.putProduct(temp);
                        } catch (RuntimeException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    if (command.equals("del")) {
                        System.out.println("Enter product id");
                        temp = Long.parseLong(bufferedReader.readLine());
                        try {
                            cart.deleteProduct(temp);
                        } catch (RuntimeException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
            }
            System.out.println("Application was closed!");

        } catch (IOException e) {
            e.printStackTrace();
        }
        context.close();
    }
}
