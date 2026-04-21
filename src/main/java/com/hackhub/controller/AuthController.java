package com.hackhub.controller;

import com.hackhub.model.*;
import com.hackhub.service.*;
import com.hackhub.validator.*;
import com.hackhub.dto.*;

import com.hackhub.model.Utente;
import com.hackhub.service.AuthService;
import com.hackhub.validator.AuthValidator;

public class AuthController {

    private AuthService authService;
    private AuthValidator authValidator;

    public AuthController(AuthService authService, AuthValidator authValidator) {
        this.authService = authService;
        this.authValidator = authValidator;
    }

    public Utente registrati(String nome, String cognome,
                             String email, String password) {
        authValidator.validateRegistrazione(nome, cognome, email, password);
        return authService.registrati(nome, cognome, email, password);
    }

    public Utente login(String email, String password) {
        authValidator.validateLogin(email, password);
        return authService.login(email, password);
    }
}