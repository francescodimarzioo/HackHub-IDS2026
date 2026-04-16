import controller.AuthController;
import controller.HackathonController;
import controller.InvitoController;
import controller.TeamController;
import model.*;
import repository.*;
import service.*;
import validator.*;

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

    }
}