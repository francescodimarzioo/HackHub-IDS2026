package service;

import model.Hackathon;
import model.Organizzatore;
import model.StatoHackathon;
import repository.IHackathonRepository;

public class HackathonService {

    private IHackathonRepository hackathonRepository;

    public HackathonService(IHackathonRepository hackathonRepository) {
        this.hackathonRepository = hackathonRepository;
    }

    public Hackathon creaHackathon(String nome, String regolamento, String luogo,
                                   Double premioInDenaro, int dimensioneMaxTeam,
                                   Organizzatore organizzatore) {
        Hackathon hackathon = new Hackathon(null, nome, regolamento, luogo,
                premioInDenaro, dimensioneMaxTeam, organizzatore);
        return hackathonRepository.save(hackathon);
    }

    public Hackathon avviaFaseIscrizione(Long idHackathon, Long idOrganizzatore) {
        Hackathon hackathon = hackathonRepository.findById(idHackathon);
        if (hackathon == null) {
            throw new IllegalArgumentException("Hackathon non trovato");
        }
        if (hackathon.getStato() != StatoHackathon.IN_ATTESA) {
            throw new IllegalStateException("Stato non valido per avviare la fase iscrizione");
        }
        if (!hackathon.getOrganizzatore().getId().equals(idOrganizzatore)) {
            throw new IllegalArgumentException("Organizzatore non autorizzato");
        }
        hackathon.setStato(StatoHackathon.IN_ISCRIZIONE);
        return hackathonRepository.save(hackathon);
    }

    public Hackathon concludiFaseIscrizione(Long idHackathon, Long idOrganizzatore) {
        Hackathon hackathon = hackathonRepository.findById(idHackathon);
        if (hackathon == null) {
            throw new IllegalArgumentException("Hackathon non trovato");
        }
        if (hackathon.getStato() != StatoHackathon.IN_ISCRIZIONE) {
            throw new IllegalStateException("Stato non valido per concludere la fase iscrizione");
        }
        if (!hackathon.getOrganizzatore().getId().equals(idOrganizzatore)) {
            throw new IllegalArgumentException("Organizzatore non autorizzato");
        }
        hackathon.setStato(StatoHackathon.IN_CORSO);
        return hackathonRepository.save(hackathon);
    }

    public Hackathon avviaFaseSvolgimento(Long idHackathon, Long idOrganizzatore) {
        Hackathon hackathon = hackathonRepository.findById(idHackathon);
        if (hackathon == null) {
            throw new IllegalArgumentException("Hackathon non trovato");
        }
        if (hackathon.getStato() != StatoHackathon.IN_CORSO) {
            throw new IllegalStateException("Stato non valido per avviare la fase svolgimento");
        }
        if (!hackathon.getOrganizzatore().getId().equals(idOrganizzatore)) {
            throw new IllegalArgumentException("Organizzatore non autorizzato");
        }
        hackathon.setStato(StatoHackathon.IN_VALUTAZIONE);
        return hackathonRepository.save(hackathon);
    }

    public Hackathon concludiFaseSvolgimento(Long idHackathon, Long idOrganizzatore) {
        Hackathon hackathon = hackathonRepository.findById(idHackathon);
        if (hackathon == null) {
            throw new IllegalArgumentException("Hackathon non trovato");
        }
        if (hackathon.getStato() != StatoHackathon.IN_VALUTAZIONE) {
            throw new IllegalStateException("Stato non valido per concludere la fase svolgimento");
        }
        if (!hackathon.getOrganizzatore().getId().equals(idOrganizzatore)) {
            throw new IllegalArgumentException("Organizzatore non autorizzato");
        }
        hackathon.setStato(StatoHackathon.CONCLUSO);
        return hackathonRepository.save(hackathon);
    }
}