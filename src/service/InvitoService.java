package service;

import model.Invito;
import model.Team;
import model.Utente;
import repository.IInvitoRepository;
import repository.IUtenteRepository;

public class InvitoService {

    private IInvitoRepository invitoRepository;
    private IUtenteRepository utenteRepository;

    public InvitoService(IInvitoRepository invitoRepository,
                         IUtenteRepository utenteRepository) {
        this.invitoRepository = invitoRepository;
        this.utenteRepository = utenteRepository;
    }

    public Invito invitaUtente(Long idTeam, Long idDestinatario, Long idLeader) {
        Utente destinatario = utenteRepository.findById(idDestinatario);
        if (destinatario == null) {
            throw new IllegalArgumentException("Utente non trovato");
        }

        Team team = new Team(idTeam, null, null, null);
        Utente mittente = new Utente(idLeader, null, null, null, null);

        Invito invito = new Invito(null, mittente, destinatario, team);
        return invitoRepository.save(invito);
    }

    public Invito rispondiInvito(Long idInvito, String risposta, Long idUtente) {
        Invito invito = invitoRepository.findById(idInvito);
        if (invito == null) {
            throw new IllegalArgumentException("Invito non trovato");
        }

        if (!invito.getDestinatario().getId().equals(idUtente)) {
            throw new IllegalArgumentException("Utente non autorizzato");
        }

        if (risposta.equals("ACCETTATO")) {
            invito.accetta();
        } else if (risposta.equals("RIFIUTATO")) {
            invito.rifiuta();
        } else {
            throw new IllegalArgumentException("Risposta non valida");
        }

        return invitoRepository.save(invito);
    }
}