package com.ssandyy.ecommercebackend.service;

import com.ssandyy.ecommercebackend.entities.User;
import com.ssandyy.ecommercebackend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    @Autowired
    private final UserRepository userRepository;
    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAllByDeletedIsNull();
    }

    @Override
    public User userUpdate(User user) {
        User existingUser = userRepository.findById(user.getId()).orElse(null);
        if (existingUser != null) {existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());
            existingUser.setPhone(user.getPhone());
            existingUser.setRole(user.getRole());
            return existingUser;
        }else{
            return null;
        }
    }

    @Override
    public User deleteUserById(Long id) {
        /*userRepository.deleteById(id);*/
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setDeleted(LocalDateTime.now());
            return userRepository.save(existingUser);
        }else {
            return null;
        }
    }
}
