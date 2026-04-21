package com.hackhub.repository;

import com.hackhub.model.*;

import com.hackhub.model.Utente;
import java.util.ArrayList;
import java.util.List;

public class UtenteRepositoryImpl implements IUtenteRepository {

    private List<Utente> utenti = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public Utente findById(Long id) {
        for (Utente u : utenti) {
            if (u.getId().equals(id)) {
                return u;
            }
        }
        return null;
    }

    @Override
    public Utente findByEmail(String email) {
        for (Utente u : utenti) {
            if (u.getEmail().equals(email)) {
                return u;
            }
        }
        return null;
    }

    @Override
    public Utente save(Utente utente) {
        if (utente.getId() == null) {
            utente.setId(nextId++);
            utenti.add(utente);
        } else {
            for (int i = 0; i < utenti.size(); i++) {
                if (utenti.get(i).getId().equals(utente.getId())) {
                    utenti.set(i, utente);
                    return utente;
                }
            }
        }
        return utente;
    }
}
