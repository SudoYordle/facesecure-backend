package com.facebackend.backend.service;

import com.facebackend.backend.dto.UserDTO;
import com.facebackend.backend.model.User;
import com.facebackend.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Helper to convert User entity to UserDTO
    private UserDTO convertToDTO(User user) {
        return new UserDTO(user.getId(), user.getNombre(), user.getEmail(), user.getPassword()); // Contraseña incluida
    }

    public UserDTO createUser(User user) {
        // En un futuro, la contraseña debería ser hasheada aquí antes de guardarse
        User savedUser = userRepository.save(user);
        return convertToDTO(savedUser);
    }

    public Optional<UserDTO> getUserById(Long id) {
        return userRepository.findById(id).map(this::convertToDTO);
    }

    public Optional<UserDTO> getUserByEmail(String email) {
        return userRepository.findByEmail(email).map(this::convertToDTO);
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public UserDTO updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));

        user.setNombre(userDetails.getNombre());
        user.setEmail(userDetails.getEmail());
        
        // Es mejor tener un endpoint separado para actualizar contraseñas,
        // pero por ahora, la actualizaremos si se provee una nueva.
        if (userDetails.getPassword() != null && !userDetails.getPassword().isEmpty()) {
            // La contraseña debería ser hasheada aquí también
            user.setPassword(userDetails.getPassword());
        }

        User updatedUser = userRepository.save(user);
        return convertToDTO(updatedUser);
    }

    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found with id " + id);
        }
        userRepository.deleteById(id);
    }
}