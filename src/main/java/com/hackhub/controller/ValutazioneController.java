package com.hackhub.controller;

import com.hackhub.model.*;
import com.hackhub.service.*;
import com.hackhub.validator.*;
import com.hackhub.dto.*;

import com.hackhub.model.Giudice;
import com.hackhub.model.Valutazione;
import com.hackhub.service.ValutazioneService;
import com.hackhub.validator.ValutazioneValidator;

public class ValutazioneController {

    private ValutazioneService valutazioneService;
    private ValutazioneValidator valutazioneValidator;

    public ValutazioneController(ValutazioneService valutazioneService,
                                 ValutazioneValidator valutazioneValidator) {
        this.valutazioneService = valutazioneService;
        this.valutazioneValidator = valutazioneValidator;
    }

    public Valutazione valutaSottomissione(Long idSottomissione, String giudizio,
                                           int punteggio, Giudice giudice) {
        valutazioneValidator.validateInputUtente(idSottomissione, giudizio,
                punteggio, giudice.getId());
        return valutazioneService.valutaSottomissione(idSottomissione, giudizio,
                punteggio, giudice);
    }
}