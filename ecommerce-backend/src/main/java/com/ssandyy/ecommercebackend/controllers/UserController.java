package com.ssandyy.ecommercebackend.controllers;

import com.ssandyy.ecommercebackend.entities.User;
import com.ssandyy.ecommercebackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("addUser")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @GetMapping("findUser/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("findAllUsers")
    public List<User> getUserList() {
        return userService.getAllUsers();
    }

    @PutMapping("userUpdate")
    public User UpdateUser(@RequestBody User user) {
        return userService.userUpdate(user);
    }

    @DeleteMapping("userDelete/{id}")
    public User DeleteUser(@PathVariable Long id) {
        return userService.deleteUserById(id);
    }
}
