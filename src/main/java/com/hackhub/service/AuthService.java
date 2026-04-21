package com.hackhub.service;

import com.hackhub.model.*;
import com.hackhub.repository.*;

import com.hackhub.model.Utente;
import com.hackhub.repository.IUtenteRepository;

public class AuthService {

    private IUtenteRepository utenteRepository;

    public AuthService(IUtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }

    public Utente registrati(String nome, String cognome,
                             String email, String password) {
        Utente esistente = utenteRepository.findByEmail(email);
        if (esistente != null) {
            throw new IllegalStateException("Email già registrata");
        }

        Utente utente = new Utente(null, nome, cognome, email, password);
        utente.registrati();
        return utenteRepository.save(utente);
    }

    public Utente login(String email, String password) {
        Utente utente = utenteRepository.findByEmail(email);
        if (utente == null) {
            throw new IllegalArgumentException("Utente non trovato");
        }
        if (!utente.getPassword().equals(password)) {
            throw new IllegalArgumentException("Password errata");
        }
        utente.login();
        return utente;
    }
}