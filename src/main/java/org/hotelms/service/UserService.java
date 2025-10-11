package org.hotelms.service;

import java.util.*;

import org.hotelms.entity.User;
import org.hotelms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // ✅ LOGIN SERVICE
    public Map<String, String> login(String email, String password) {
        Map<String, String> res = new HashMap<>();
        Optional<User> userOpt = userRepository.findByEmail(email);

        if (userOpt.isEmpty()) {
            res.put("status", "error");
            res.put("message", "User not found");
            return res;
        }

        User user = userOpt.get();

        if (!user.getPassword().equals(password)) {
            res.put("status", "error");
            res.put("message", "Invalid password");
            return res;
        }

        if (!user.getStatus().equalsIgnoreCase("ACTIVE")) {
            res.put("status", "error");
            res.put("message", "Account inactive");
            return res;
        }

        res.put("status", "success");
        res.put("role", user.getRole());
        res.put("message", "Login successful");
        return res;
    }

    // ✅ CRUD Methods
    public String addUser(User user) {
        userRepository.save(user);
        return "User added successfully!";
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public String updateUser(int id, User user) {
        Optional<User> existing = userRepository.findById(id);
        if (existing.isPresent()) {
            User u = existing.get();
            u.setEmail(user.getEmail());
            u.setPassword(user.getPassword());
            u.setRole(user.getRole());
            u.setStatus(user.getStatus());
            u.setUpdated_at(java.time.LocalDateTime.now());
            userRepository.save(u);
            return "User updated successfully!";
        } else {
            return "User not found!";
        }
    }

    public String deleteUser(int id) {
        userRepository.deleteById(id);
        return "User deleted successfully!";
    }
}
