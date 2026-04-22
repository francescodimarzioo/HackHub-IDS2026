package com.hackhub.controller;

import com.hackhub.model.*;
import com.hackhub.service.*;
import com.hackhub.validator.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/valutazione")
public class ValutazioneController {

    @Autowired
    private ValutazioneService valutazioneService;

    @Autowired
    private ValutazioneValidator valutazioneValidator;

    @PostMapping("/valuta")
    public ResponseEntity<Valutazione> valutaSottomissione(@RequestParam Long idSottomissione,
                                                           @RequestParam String giudizio,
                                                           @RequestParam int punteggio,
                                                           @RequestParam Long idGiudice) {
        valutazioneValidator.validateInputUtente(idSottomissione, giudizio, punteggio, idGiudice);
        Giudice giudice = new Giudice();
        giudice.setId(idGiudice);
        return ResponseEntity.ok(valutazioneService.valutaSottomissione(idSottomissione,
                giudizio, punteggio, giudice));
    }
}