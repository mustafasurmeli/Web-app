package com.mendixweb.mendix.controllers;

import com.mendixweb.mendix.entities.User;
import com.mendixweb.mendix.repos.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserRepository userRepository;
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getUsers() {
        return userRepository.findAll();
    }
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        User foundUser = userRepository.findById(id).orElse(null);
        if (foundUser != null) {
            foundUser.setUsername(user.getUsername());
            foundUser.setPassword(user.getPassword());
            userRepository.save(foundUser);
        }
        return foundUser;
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
