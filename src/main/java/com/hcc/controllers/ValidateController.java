package com.hcc.controllers;

import com.hcc.entities.Assignment;
import com.hcc.entities.User;
import com.hcc.repositories.AssignmentRepository;
import com.hcc.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping
@RestController
public class ValidateController {
    // /api/auth/validate
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JWTUtils jwtUtils;

    @GetMapping("/api/auth/validate")
    ResponseEntity<?> validateToken(@RequestParam String token, @AuthenticationPrincipal User user) {
        if (user != null) {
            boolean isTokenValid = jwtUtils.validateToken(token, user);
            return ResponseEntity.ok(isTokenValid);
        } else {
            return ResponseEntity.ok(false);
        }

    }
}
