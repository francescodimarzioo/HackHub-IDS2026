import controller.AuthController;
import controller.HackathonController;
import controller.InvitoController;
import controller.TeamController;
import model.*;
import repository.*;
import service.*;
import validator.*;
import controller.SottomissioneController;
import controller.ValutazioneController;
import model.Giudice;
import model.Mentore;
import model.Sottomissione;
import model.Valutazione;
import repository.SottomissioneRepositoryImpl;
import repository.ValutazioneRepositoryImpl;
import service.SottomissioneService;
import service.ValutazioneService;
import validator.SottomissioneValidator;
import validator.ValutazioneValidator;

public class Main {

    public static void main(String[] args) {


        UtenteRepositoryImpl utenteRepository = new UtenteRepositoryImpl();
        HackathonRepositoryImpl hackathonRepository = new HackathonRepositoryImpl();
        TeamRepositoryImpl teamRepository = new TeamRepositoryImpl();
        InvitoRepositoryImpl invitoRepository = new InvitoRepositoryImpl();


        AuthController authController = new AuthController(
                new AuthService(utenteRepository),
                new AuthValidator()
        );

        HackathonController hackathonController = new HackathonController(
                new HackathonService(hackathonRepository),
                new HackathonValidator()
        );

        TeamController teamController = new TeamController(
                new TeamService(teamRepository, hackathonRepository),
                new TeamValidator()
        );

        InvitoController invitoController = new InvitoController(
                new InvitoService(invitoRepository, utenteRepository),
                new InvitoValidator()
        );

        // UC1 - Registrazione
        System.out.println(" UC1: Registrazione");
        Utente utente = authController.registrati(
                "Francesco", "Di Marzio", "francesco@email.com", "password123");
        System.out.println("Utente registrato con id: " + utente.getId());
        System.out.println();

        // UC2 - Login
        System.out.println("UC2: Login");
        Utente loggato = authController.login("francesco@email.com", "password123");
        System.out.println("Utente loggato: " + loggato.getEmail());
        System.out.println();

        // UC3 - Creare Hackathon
        System.out.println("UC3: Creare Hackathon");
        Organizzatore organizzatore = new Organizzatore(
                1L, "Nicla", "Di Biase", "nicla@email.com", "pass123", "Bio", "linkedin.com/nicla");
        Hackathon hackathon = hackathonController.creaHackathon(
                "HackathonTest", "Regolamento", "Pescara", 1000.0, 5, organizzatore);
        System.out.println("Hackathon creato con id: " + hackathon.getId()
                + " stato: " + hackathon.getStato());
        System.out.println();

        // UC4 - Avvio Fase Iscrizione
        System.out.println("UC4: Avvio Fase Iscrizione");
        hackathonController.avviaFaseIscrizione(hackathon.getId(), organizzatore.getId());
        System.out.println("Stato hackathon: " + hackathon.getStato());
        System.out.println();

        // UC5 - Conclusione Fase Iscrizione
        System.out.println("UC5: Conclusione Fase Iscrizione");
        hackathonController.concludiFaseIscrizione(hackathon.getId(), organizzatore.getId());
        System.out.println("Stato hackathon: " + hackathon.getStato());
        System.out.println();

        // UC6 - Avvio Fase Svolgimento
        System.out.println("UC6: Avvio Fase Svolgimento");
        hackathonController.avviaFaseSvolgimento(hackathon.getId(), organizzatore.getId());
        System.out.println("Stato hackathon: " + hackathon.getStato());
        System.out.println();

        // UC7 - Conclusione Fase Svolgimento
        System.out.println("UC7: Conclusione Fase Svolgimento");
        hackathonController.concludiFaseSvolgimento(hackathon.getId(), organizzatore.getId());
        System.out.println("Stato hackathon: " + hackathon.getStato());
        System.out.println();


        Hackathon hackathon2 = hackathonController.creaHackathon(
                "HackathonTest2", "Regolamento2", "Roma", 2000.0, 4, organizzatore);
        hackathonController.avviaFaseIscrizione(hackathon2.getId(), organizzatore.getId());

        LeaderTeam leader = new LeaderTeam(
                2L, "Mariadele", "Di Biase", "mariadele@email.com", "pass123");
        utenteRepository.save(leader);

        Utente destinatario = authController.registrati("Fabiana", "Felicioni", "fabiana@email.com", "pass123");

        // UC1 - Creare Team
        System.out.println("UC1: Creare Team");
        Team team = teamController.creaTeam(hackathon2.getId(), "TeamTest", leader);
        System.out.println("Team creato con id: " + team.getId()
                + " nome: " + team.getNome());
        System.out.println();

        // UC2 - Iscrivere Team a Hackathon
        System.out.println("UC2: Iscrivere Team a Hackathon");
        teamController.iscriviTeam(team.getId(), hackathon2.getId(), leader.getId());
        System.out.println("Team iscritto all'hackathon: " + hackathon2.getNome());
        System.out.println();

        // UC3 - Invitare Utente
        System.out.println("UC3: Invitare Utente");
        Invito invito = invitoController.invitaUtente(
                team.getId(), destinatario.getId(), leader.getId());
        System.out.println("Invito creato con id: " + invito.getId()
                + " stato: " + invito.getStato());
        System.out.println();

        // UC4 - Gestire Invito - Accetta
        System.out.println("UC4: Gestire Invito (Accetta)");
        Invito risposta = invitoController.rispondiInvito(
                invito.getId(), "ACCETTATO", destinatario.getId());
        System.out.println("Invito stato: " + risposta.getStato());
        System.out.println();
        SottomissioneRepositoryImpl sottomissioneRepository = new SottomissioneRepositoryImpl();
        ValutazioneRepositoryImpl valutazioneRepository = new ValutazioneRepositoryImpl();

        SottomissioneController sottomissioneController = new SottomissioneController(
                new SottomissioneService(sottomissioneRepository, teamRepository),
                new SottomissioneValidator()
        );

        ValutazioneController valutazioneController = new ValutazioneController(
                new ValutazioneService(valutazioneRepository, sottomissioneRepository),
                new ValutazioneValidator()
        );

// Setup dati iniziali iterazione 3
        Hackathon hackathon3 = hackathonController.creaHackathon(
                "HackathonTest3", "Regolamento3", "Milano", 3000.0, 5, organizzatore);
        hackathonController.avviaFaseIscrizione(hackathon3.getId(), organizzatore.getId());

        LeaderTeam leader3 = new LeaderTeam(
                4L, "Mario", "Di Ciano", "mario@email.com", "pass123");
        utenteRepository.save(leader3);

        Team team3 = teamController.creaTeam(hackathon3.getId(), "TeamTest3", leader3);
        teamController.iscriviTeam(team3.getId(), hackathon3.getId(), leader3.getId());
        hackathonController.concludiFaseIscrizione(hackathon3.getId(), organizzatore.getId());

        Giudice giudice = new Giudice(
                5L, "Luca", "Di Crescenzo", "luca@email.com", "pass123",
                "Bio", "linkedin.com/luca", "Criterio");

// UC1 - Modificare Hackathon
        System.out.println("UC1: Modificare Hackathon");
        Hackathon hackathon3b = hackathonController.creaHackathon(
                "HackathonDaModificare", "Regolamento", "Roma", 500.0, 3, organizzatore);
        hackathonController.modificaHackathon(
                hackathon3b.getId(), "HackathonModificato", "NuovoRegolamento",
                "Pescara", 1500.0, 4, organizzatore.getId());
        System.out.println("Hackathon modificato: " + hackathon3b.getNome());
        System.out.println();

// UC2 - Aggiungere Mentore
        System.out.println("UC2: Aggiungere Mentore");
        Mentore mentore = new Mentore(
                6L, "Anna", "Russo", "anna@email.com", "pass123",
                "Bio", "linkedin.com/anna", "Java");
        hackathonController.aggiungiMentore(hackathon3.getId(), mentore, organizzatore.getId());
        System.out.println();

// UC3 - Inviare Sottomissione
        System.out.println("UC3: Inviare Sottomissione");
        hackathonController.avviaFaseSvolgimento(hackathon3.getId(), organizzatore.getId());
        Sottomissione sottomissione = sottomissioneController.inviaSottomissione(
                team3.getId(), hackathon3.getId(),
                "https://github.com/team3/progetto", leader3.getId());
        System.out.println("Sottomissione inviata con id: " + sottomissione.getId());
        System.out.println();

// UC4 - Aggiornare Sottomissione
        System.out.println("UC4: Aggiornare Sottomissione");
        sottomissioneController.aggiornaSottomissione(
                sottomissione.getId(), "https://github.com/team3/progetto-v2", leader3.getId());
        System.out.println("Sottomissione aggiornata.");
        System.out.println();

// UC5 - Visualizzare Sottomissioni
        System.out.println("UC5: Visualizzare Sottomissioni");
        sottomissioneController.visualizzaSottomissioni(hackathon3.getId(), giudice.getId());
        System.out.println("Sottomissioni visualizzate.");
        System.out.println();

// UC6 - Valutare Sottomissione
        System.out.println("UC6: Valutare Sottomissione");
        hackathonController.concludiFaseSvolgimento(hackathon3.getId(), organizzatore.getId());
        Valutazione valutazione = valutazioneController.valutaSottomissione(
                sottomissione.getId(), "Ottimo lavoro", 9, giudice);
        System.out.println("Valutazione creata con punteggio: " + valutazione.getPunteggio());
        System.out.println();

// UC7 - Proclamare Vincitore
        System.out.println("UC7: Proclamare Vincitore");
        hackathon3.getTeam().add(team3);
        hackathonController.proclamaVincitore(
                hackathon3.getId(), team3.getId(), organizzatore.getId());
        System.out.println("Vincitore proclamato: " + hackathon3.getTeamVincitore().getNome());
        System.out.println();

// UC8 - Erogare Premio
        System.out.println("UC8: Erogare Premio");
        hackathonController.erogaPremio(hackathon3.getId());
        System.out.println();

// UC9 - Chiusura Automatica Iscrizioni
        System.out.println("UC9: Chiusura Automatica Iscrizioni");
        hackathonController.verificaScadenzaIscrizioni();
        System.out.println();
    }

}