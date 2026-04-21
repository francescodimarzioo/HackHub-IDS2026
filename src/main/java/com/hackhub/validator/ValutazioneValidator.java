package com.hackhub.validator;

import com.hackhub.model.*;
import com.hackhub.dto.*;

public class ValutazioneValidator {

    public void validateInputUtente(Long idSottomissione, String giudizio,
                                    int punteggio, Long idGiudice) {
        if (idSottomissione == null) {
            throw new IllegalArgumentException("idSottomissione non può essere null");
        }
        if (giudizio == null || giudizio.isEmpty()) {
            throw new IllegalArgumentException("giudizio non può essere null o vuoto");
        }
        if (punteggio < 0 || punteggio > 10) {
            throw new IllegalArgumentException("punteggio deve essere compreso tra 0 e 10");
        }
        if (idGiudice == null) {
            throw new IllegalArgumentException("idGiudice non può essere null");
        }
        System.out.println("Input valutaSottomissione validato correttamente.");
    }
}