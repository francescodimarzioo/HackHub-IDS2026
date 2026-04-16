package controller;

import model.Utente;
import service.AuthService;
import validator.AuthValidator;

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