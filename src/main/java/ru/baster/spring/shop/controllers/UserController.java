package ru.baster.spring.shop.controllers;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.baster.spring.shop.service.UserService;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String showUsersPage(Model model) {
        model.addAttribute("items", userService.getAll());
        return "users/users";
    }

    @GetMapping("/users/{id}")
    public String showUserById(Model model, @PathVariable Long id) {
        model.addAttribute("user", userService.findById(id));
        return "users/retrieve_user";
    }

    @GetMapping("/users/add")
    public String showAddUser_Form() {
        return "users/add_user_form";
    }

    @PostMapping("/users/add")
    public String saveUser(@RequestParam String name, @RequestParam String username) {
        userService.AddNewUser(name, username);
        return "redirect:/users";
    }
}
