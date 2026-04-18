package service;

import model.Hackathon;
import model.Sottomissione;
import model.StatoHackathon;
import model.Team;
import repository.ISottomissioneRepository;
import repository.ITeamRepository;
import java.util.List;

public class SottomissioneService {

    private ISottomissioneRepository sottomissioneRepository;
    private ITeamRepository teamRepository;

    public SottomissioneService(ISottomissioneRepository sottomissioneRepository,
                                ITeamRepository teamRepository) {
        this.sottomissioneRepository = sottomissioneRepository;
        this.teamRepository = teamRepository;
    }

    public Sottomissione inviaSottomissione(Long idTeam, Long idHackathon,
                                            String link, Long idLeader) {
        Team team = teamRepository.findById(idTeam);
        if (team == null) {
            throw new IllegalArgumentException("Team non trovato");
        }
        if (!team.getLeader().getId().equals(idLeader)) {
            throw new IllegalArgumentException("Leader non autorizzato");
        }
        if (team.getHackathon().getStato() != StatoHackathon.IN_CORSO) {
            throw new IllegalStateException("Hackathon non in stato IN_CORSO");
        }

        Sottomissione esistente = sottomissioneRepository.findByTeam(team);
        if (esistente != null) {
            throw new IllegalStateException("Il team ha già inviato una sottomissione");
        }

        Sottomissione sottomissione = new Sottomissione(null, link, team, team.getHackathon());
        System.out.println("Sottomissione inviata dal team " + team.getNome());
        return sottomissioneRepository.save(sottomissione);
    }

    public Sottomissione aggiornaSottomissione(Long idSottomissione,
                                               String nuovoLink, Long idLeader) {
        Sottomissione sottomissione = sottomissioneRepository.findById(idSottomissione);
        if (sottomissione == null) {
            throw new IllegalArgumentException("Sottomissione non trovata");
        }
        if (!sottomissione.getTeam().getLeader().getId().equals(idLeader)) {
            throw new IllegalArgumentException("Leader non autorizzato");
        }
        if (sottomissione.getTeam().getHackathon().getStato() != StatoHackathon.IN_CORSO) {
            throw new IllegalStateException("Hackathon non più in stato IN_CORSO");
        }

        sottomissione.aggiornaLink(nuovoLink);
        return sottomissioneRepository.save(sottomissione);
    }

    public List<Sottomissione> visualizzaSottomissioni(Long idHackathon, Long idGiudice) {
        List<Sottomissione> sottomissioni = sottomissioneRepository.findByHackathon(
                new Hackathon(idHackathon, null, null, null, null, 0, null));
        if (sottomissioni.isEmpty()) {
            System.out.println("Nessuna sottomissione trovata per questo hackathon.");
        }
        return sottomissioni;
    }
}