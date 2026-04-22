package com.hackhub.validator;

import org.springframework.stereotype.Component;

@Component
public class SegnalazioneValidator {

    public void validateInputUtente(Long idHackathon, String descrizione, Long idMembroTeam) {
        if (idHackathon == null) {
            throw new IllegalArgumentException("idHackathon non può essere null");
        }
        if (descrizione == null || descrizione.isEmpty()) {
            throw new IllegalArgumentException("descrizione non può essere null o vuota");
        }
        if (idMembroTeam == null) {
            throw new IllegalArgumentException("idMembroTeam non può essere null");
        }
    }
}