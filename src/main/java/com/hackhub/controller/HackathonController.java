package com.hackhub.controller;

import com.hackhub.model.*;
import com.hackhub.service.*;
import com.hackhub.validator.*;
import com.hackhub.dto.*;

import com.hackhub.model.Hackathon;
import com.hackhub.model.Organizzatore;
import com.hackhub.service.HackathonService;
import com.hackhub.validator.HackathonValidator;
import com.hackhub.model.Mentore;

public class HackathonController {

    private HackathonService hackathonService;
    private HackathonValidator hackathonValidator;

    public HackathonController(HackathonService hackathonService,
                               HackathonValidator hackathonValidator) {
        this.hackathonService = hackathonService;
        this.hackathonValidator = hackathonValidator;
    }

    public Hackathon creaHackathon(String nome, String regolamento, String luogo,
                                   Double premioInDenaro, int dimensioneMaxTeam,
                                   Organizzatore organizzatore) {
        hackathonValidator.validateInputCreaHackathon(nome, regolamento, luogo,
                premioInDenaro, dimensioneMaxTeam,
                organizzatore.getId());
        return hackathonService.creaHackathon(nome, regolamento, luogo,
                premioInDenaro, dimensioneMaxTeam, organizzatore);
    }

    public Hackathon avviaFaseIscrizione(Long idHackathon, Long idOrganizzatore) {
        hackathonValidator.validateInputAvviaFase(idHackathon, idOrganizzatore);
        return hackathonService.avviaFaseIscrizione(idHackathon, idOrganizzatore);
    }

    public Hackathon concludiFaseIscrizione(Long idHackathon, Long idOrganizzatore) {
        hackathonValidator.validateInputAvviaFase(idHackathon, idOrganizzatore);
        return hackathonService.concludiFaseIscrizione(idHackathon, idOrganizzatore);
    }

    public Hackathon avviaFaseSvolgimento(Long idHackathon, Long idOrganizzatore) {
        hackathonValidator.validateInputAvviaFase(idHackathon, idOrganizzatore);
        return hackathonService.avviaFaseSvolgimento(idHackathon, idOrganizzatore);
    }

    public Hackathon concludiFaseSvolgimento(Long idHackathon, Long idOrganizzatore) {
        hackathonValidator.validateInputAvviaFase(idHackathon, idOrganizzatore);
        return hackathonService.concludiFaseSvolgimento(idHackathon, idOrganizzatore);
    }

    public Hackathon proclamaVincitore(Long idHackathon, Long idTeamVincitore, Long idOrganizzatore) {
        hackathonValidator.validateInputProclamaVincitore(idHackathon, idTeamVincitore, idOrganizzatore);
        return hackathonService.proclamaVincitore(idHackathon, idTeamVincitore, idOrganizzatore);
    }

    public void erogaPremio(Long idHackathon) {
        hackathonService.erogaPremio(idHackathon);
    }

    public Hackathon modificaHackathon(Long idHackathon, String nome, String regolamento,
                                       String luogo, Double premioInDenaro,
                                       int dimensioneMaxTeam, Long idOrganizzatore) {
        hackathonValidator.validateInputModificaHackathon(idHackathon, idOrganizzatore);
        return hackathonService.modificaHackathon(idHackathon, nome, regolamento,
                luogo, premioInDenaro,
                dimensioneMaxTeam, idOrganizzatore);
    }

    public Hackathon aggiungiMentore(Long idHackathon, Mentore mentore, Long idOrganizzatore) {
        hackathonValidator.validateInputAggiungiMentore(idHackathon, mentore.getId(), idOrganizzatore);
        return hackathonService.aggiungiMentore(idHackathon, mentore, idOrganizzatore);
    }

    public void verificaScadenzaIscrizioni() {
        hackathonService.verificaScadenzaIscrizioni();
    }
}
