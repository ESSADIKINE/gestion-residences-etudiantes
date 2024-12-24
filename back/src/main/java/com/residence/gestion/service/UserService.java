package com.residence.gestion.service;

import com.residence.gestion.model.User;
import com.residence.gestion.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Create or Update a User
    public User createOrUpdateUser(User user) {
        return userRepository.save(user);
    }

    // Retrieve all Users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Retrieve a specific User by ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Delete a User by ID
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // Retrieve a User by Email
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
