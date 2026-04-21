package com.hackhub.repository;

import com.hackhub.model.*;

import com.hackhub.model.Utente;

public interface IUtenteRepository {

    Utente findById(Long id);

    Utente findByEmail(String email);

    Utente save(Utente utente);
}