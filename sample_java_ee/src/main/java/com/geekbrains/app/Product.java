package com.geekbrains.app;

public class Product {
    private String id;
    private String title;
    private String cost;

    public Product(String id, String title, String cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "product: " + "id - " + id + " title - " + title + " cost - " + cost;

    }
}
