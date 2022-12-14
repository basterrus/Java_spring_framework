package ru.baster.spring.shop.models;

public class User {
    private Long id;
    private String name;
    private String username;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public User(Long id, String username, String name) {
        this.id = id;
        this.username = username;
        this.name = name;
    }

    public User() {
    }


}
