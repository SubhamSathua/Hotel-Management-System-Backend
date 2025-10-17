package org.hotelms.controller;

import java.util.*;

import org.hotelms.entity.LoginRequest;
import org.hotelms.entity.LoginResponse;
import org.hotelms.entity.User;
import org.hotelms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService;

    // ✅ LOGIN API
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return userService.login(request.getEmail(), request.getPassword());
    }

    // ✅ CRUD APIs (Optional)
    @PostMapping("/addUsers")
    public String addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/allUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/updateUsers/{id}")
    public String updateUser(@PathVariable int id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/deleteUsers/{id}")
    public String deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }


    // Registration endpoint
    @PostMapping("/register")
    public Map<String, String> register(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        String password = body.get("password");
        String firstName = body.get("firstName");
        String lastName = body.get("lastName");

        Map<String, String> res = new HashMap<>();

        // Check if email already exists
        if (userService.existsByEmail(email)) {
            res.put("status", "error");
            res.put("message", "Email already registered");
            return res;
        }

        // Create new User
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setRole("CUSTOMER"); // default role
        user.setStatus("ACTIVE");

        // Save User + Profile
        userService.registerUser(user, firstName + " " + lastName);

        res.put("status", "success");
        res.put("message", "Registration successful");
        return res;
    }
}
