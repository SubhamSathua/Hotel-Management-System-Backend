package org.hotelms.controller;
import org.hotelms.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class LoginController {

    private final UserRepository userRepository;

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        return userRepository.findByUsernameAndPassword(username, password)
                .map(user -> Map.of(
                        "message", "Login successful",
                        "role", user.getRole()
                ))
                .orElse(Map.of("message", "Invalid username or password"));
    }
}
