package com.hackhub.controller;

import com.hackhub.model.*;
import com.hackhub.service.*;
import com.hackhub.validator.*;
import com.hackhub.dto.*;

import com.hackhub.model.Invito;
import com.hackhub.service.InvitoService;
import com.hackhub.validator.InvitoValidator;

public class InvitoController {

    private InvitoService invitoService;
    private InvitoValidator invitoValidator;

    public InvitoController(InvitoService invitoService,
                            InvitoValidator invitoValidator) {
        this.invitoService = invitoService;
        this.invitoValidator = invitoValidator;
    }

    public Invito invitaUtente(Long idTeam, Long idDestinatario, Long idLeader) {
        invitoValidator.validateInputUtente(idTeam, idDestinatario, idLeader);
        return invitoService.invitaUtente(idTeam, idDestinatario, idLeader);
    }

    public Invito rispondiInvito(Long idInvito, String risposta, Long idUtente) {
        invitoValidator.validateInputRisposta(idInvito, risposta, idUtente);
        return invitoService.rispondiInvito(idInvito, risposta, idUtente);
    }
}