package com.hackhub.service;

import com.hackhub.model.*;
import com.hackhub.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private IUtenteRepository utenteRepository;

    public Utente registrati(String nome, String cognome,
                             String email, String password) {
        Utente esistente = utenteRepository.findByEmail(email).orElse(null);
        if (esistente != null) {
            throw new IllegalStateException("Email già registrata");
        }

        Utente utente = new Utente(null, nome, cognome, email, password);
        utente.registrati();
        return utenteRepository.save(utente);
    }

    public Utente login(String email, String password) {
        Utente utente = utenteRepository.findByEmail(email).orElse(null);
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