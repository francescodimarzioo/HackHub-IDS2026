package com.hackhub.validator;

import org.springframework.stereotype.Component;

@Component
public class SupportoValidator {

    public void validateInputUtente(Long idRichiesta, String tipoCall, Long idMentore) {
        if (idRichiesta == null) {
            throw new IllegalArgumentException("idRichiesta non può essere null");
        }
        if (tipoCall == null || tipoCall.isEmpty()) {
            throw new IllegalArgumentException("tipoCall non può essere null o vuoto");
        }
        if (idMentore == null) {
            throw new IllegalArgumentException("idMentore non può essere null");
        }
    }
}