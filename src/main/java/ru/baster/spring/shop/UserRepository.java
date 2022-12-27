package ru.baster.spring.shop;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import ru.baster.spring.shop.exeptions.NotFoundProductException;
import ru.baster.spring.shop.models.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class UserRepository {
    private List<User> items;


    @PostConstruct
    private void initUsers() {
        this.items = new ArrayList<>(List.of(
                new User(1L, "test", "user_name")
        ));
    }

    public List<User> getAllUsers() {
        return Collections.unmodifiableList(items);
    }

    public void add(User user) {
        user.setId(items.stream().mapToLong(User::getId).max().getAsLong() + 1L);
        items.add(user);
    }

    public User getById(Long id) {
        for (User u : items) {
            if (u.getId().equals(id)) {
                return u;
            }
        }
        throw new NotFoundProductException();
    }

    public void addUser(User user) {
        user.setId(items.stream().mapToLong(User::getId).max().getAsLong() + 1L);
        items.add(user);
    }
}
