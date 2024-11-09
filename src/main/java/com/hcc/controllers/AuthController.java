package com.hcc.controllers;

import com.hcc.entities.Assignment;
import com.hcc.entities.AuthCredentialsRequest;
import com.hcc.entities.User;
import com.hcc.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthService authService;

    @PostMapping("/login")
    ResponseEntity<?> login(@RequestBody AuthCredentialsRequest request) {
        ResponseEntity<String> username = authService.login(request);
        return ResponseEntity.ok(username);
    }

    @GetMapping("/validate")
    ResponseEntity<?> validateToken(@AuthenticationPrincipal User user, @RequestParam String token) {
        Boolean isValid = authService.validateToken(user, token);
        return ResponseEntity.ok(isValid);
    }
}
