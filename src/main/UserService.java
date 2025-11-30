package com.facesecure.backend.service;

import com.facesecure.backend.model.User;
import com.facesecure.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public User createUser(User user) {
        user.setCreatedAt(System.currentTimeMillis());
        user.setUpdatedAt(System.currentTimeMillis());
        return userRepository.save(user);
    }
    
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
    
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    public User updateUser(Long id, User userDetails) {
        return userRepository.findById(id).map(user -> {
            user.setEmail(userDetails.getEmail());
            user.setPassword(userDetails.getPassword());
            user.setFaceEmbedding(userDetails.getFaceEmbedding());
            user.setUpdatedAt(System.currentTimeMillis());
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }
    
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}