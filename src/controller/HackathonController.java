package controller;

import model.Hackathon;
import model.Organizzatore;
import service.HackathonService;
import validator.HackathonValidator;

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
}
