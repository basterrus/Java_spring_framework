package ru.baster.spring.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.baster.spring.shop.models.User;
import ru.baster.spring.shop.UserRepository;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        return userRepository.getAllUsers();
    }
    public User findById(Long id) {
        return userRepository.getById(id);
    }

    public void AddNewUser(String name, String username) {
        User user = new User(null, name, username);
        userRepository.add(user);
    }

}
