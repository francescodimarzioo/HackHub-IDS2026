package com.hackhub.controller;

import com.hackhub.model.*;
import com.hackhub.service.*;
import com.hackhub.validator.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private AuthValidator authValidator;

    @PostMapping("/registrati")
    public ResponseEntity<Utente> registrati(@RequestParam String nome,
                                             @RequestParam String cognome,
                                             @RequestParam String email,
                                             @RequestParam String password) {
        authValidator.validateRegistrazione(nome, cognome, email, password);
        return ResponseEntity.ok(authService.registrati(nome, cognome, email, password));
    }

    @PostMapping("/login")
    public ResponseEntity<Utente> login(@RequestParam String email,
                                        @RequestParam String password) {
        authValidator.validateLogin(email, password);
        return ResponseEntity.ok(authService.login(email, password));
    }
}