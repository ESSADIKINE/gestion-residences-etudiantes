package com.residence.gestion.controller;

import com.residence.gestion.model.User;
import com.residence.gestion.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    // Register a new user
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        User registeredUser = authService.registerUser(user);
        return ResponseEntity.ok(registeredUser);
    }

    // Login endpoint
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) {
        System.out.println("Login endpoint hit with email: " + email); // Debugging Log
        return authService.authenticate(email, password)
                .map(user -> ResponseEntity.ok("Login successful! Welcome, " + user.getEmail()))
                .orElse(ResponseEntity.status(401).body("Invalid credentials"));
    }

    // Logout endpoint
    @PostMapping("/logout")
    public ResponseEntity<String> logoutInfo() {
        // Instructing the client how to logout and invalidating the session
        return ResponseEntity.ok("You can logout by clearing your session or token. If you are using cookies, clear them to log out.");
    }
}
