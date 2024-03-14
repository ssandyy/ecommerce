package com.ssandyy.ecommercebackend.service;

import com.ssandyy.ecommercebackend.entities.User;

import java.util.List;
import java.util.Optional;


public interface UserService {
    public User registerUser(User user);
    public User getUserById(Long id);
    public List<User> getAllUsers();
    public User userUpdate(User user);
    public User deleteUserById(Long id);
}
