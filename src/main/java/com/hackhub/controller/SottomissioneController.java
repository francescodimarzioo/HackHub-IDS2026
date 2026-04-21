package com.hackhub.controller;

import com.hackhub.model.*;
import com.hackhub.service.*;
import com.hackhub.validator.*;
import com.hackhub.dto.*;

import com.hackhub.model.Sottomissione;
import com.hackhub.service.SottomissioneService;
import com.hackhub.validator.SottomissioneValidator;
import java.util.List;

public class SottomissioneController {

    private SottomissioneService sottomissioneService;
    private SottomissioneValidator sottomissioneValidator;

    public SottomissioneController(SottomissioneService sottomissioneService,
                                   SottomissioneValidator sottomissioneValidator) {
        this.sottomissioneService = sottomissioneService;
        this.sottomissioneValidator = sottomissioneValidator;
    }

    public Sottomissione inviaSottomissione(Long idTeam, Long idHackathon,
                                            String link, Long idLeader) {
        sottomissioneValidator.validateInputInvia(idTeam, idHackathon, link, idLeader);
        return sottomissioneService.inviaSottomissione(idTeam, idHackathon, link, idLeader);
    }

    public Sottomissione aggiornaSottomissione(Long idSottomissione,
                                               String nuovoLink, Long idLeader) {
        sottomissioneValidator.validateInputAggiorna(idSottomissione, nuovoLink, idLeader);
        return sottomissioneService.aggiornaSottomissione(idSottomissione, nuovoLink, idLeader);
    }

    public List<Sottomissione> visualizzaSottomissioni(Long idHackathon, Long idGiudice) {
        return sottomissioneService.visualizzaSottomissioni(idHackathon, idGiudice);
    }
}