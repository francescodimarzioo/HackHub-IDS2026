package controller;

import model.Giudice;
import model.Valutazione;
import service.ValutazioneService;
import validator.ValutazioneValidator;

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