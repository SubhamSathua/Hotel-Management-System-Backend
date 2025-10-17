package org.hotelms.service;

import java.time.LocalDateTime;
import java.util.*;

import org.hotelms.entity.LoginResponse;
import org.hotelms.entity.User;
import org.hotelms.entity.UserProfile;
import org.hotelms.repository.UserProfileRepository;
import org.hotelms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;

    public boolean existsByEmail(String email) {
        return userRepository.findByEmail(email).isPresent();
    }


    public LoginResponse login(String email, String password) {
        LoginResponse res = new LoginResponse();
        Optional<User> userOpt = userRepository.findByEmail(email);

        if (userOpt.isEmpty()) {
            res.setStatus("error");
            res.setMessage("User not found");
            return res;
        }

        User user = userOpt.get();

        if (!user.getPassword().equals(password)) {
            res.setStatus("error");
            res.setMessage("Invalid password");
            return res;
        }

        if (!user.getStatus().equalsIgnoreCase("ACTIVE")) {
            res.setStatus("error");
            res.setMessage("Account inactive");
            return res;
        }

        res.setStatus("success");
        res.setMessage("Login successful");
        res.setRole(user.getRole());
        return res;
    }

    public Map<String, String> registerUser(User user, String fullName) {
        Map<String, String> res = new HashMap<>();

        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            res.put("status", "error");
            res.put("message", "Email already registered");
            return res;
        }

        user.setRole("CUSTOMER");
        user.setStatus("ACTIVE");
        user.setCreated_at(LocalDateTime.now());
        user.setUpdated_at(LocalDateTime.now());

        userRepository.save(user);

        UserProfile profile = new UserProfile();
        profile.setUser(user);
        profile.setFull_name(fullName);
        profile.setCreated_at(LocalDateTime.now());
        userProfileRepository.save(profile);

        res.put("status", "success");
        res.put("message", "Registration successful");
        return res;
    }

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
            u.setUpdated_at(LocalDateTime.now());
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
