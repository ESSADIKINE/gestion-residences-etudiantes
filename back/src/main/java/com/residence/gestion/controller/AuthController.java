package com.residence.gestion.controller;

import com.residence.gestion.config.JwtTokenProvider;
import com.residence.gestion.model.User;
import com.residence.gestion.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Map<String, String> userDetails) {
        String email = userDetails.get("email");
        String password = userDetails.get("password");

        // Check if the email already exists
        if (authService.isEmailRegistered(email)) {
            return ResponseEntity.status(400).body("Email already exists");
        }

        // Create a new user with default role "RESIDENT"
        User user = new User();
        user.setEmail(email);
        user.setPassword(password); // Password will be encoded in the service
        user.setRole("RESIDENT");   // Set the default role to "RESIDENT"

        // Register the user
        authService.registerUser(user);

        return ResponseEntity.ok("User registered successfully with role RESIDENT");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");

        var user = authService.authenticate(email, password);
        if (user.isPresent()) {
            String token = jwtTokenProvider.generateToken(user.get().getEmail(), user.get().getRole());
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }
    
    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request, HttpServletResponse response) {
        String token = request.getHeader("Authorization");
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
            // Optionally add the token to a blocklist for invalidation
        }
        return ResponseEntity.ok("Logged out successfully");
    }
}
