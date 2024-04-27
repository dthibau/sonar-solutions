package com.baeldung.application.controllers;

import com.baeldung.application.entities.User;
import com.baeldung.application.repositories.UserRepository;
import java.util.List;

import com.baeldung.application.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserRepository userRepository;

    private final UserService userService;

    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    void addUser(@RequestBody User user) {
        userRepository.save(user);
    }

    @PutMapping("/users/domain")
    void addUser(@RequestParam String domain) {
        userService.updateEmailDomain(domain);
    }
}
