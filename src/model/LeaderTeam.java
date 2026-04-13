package model;

public class LeaderTeam extends MembroTeam {

    public LeaderTeam(Long id, String nome, String cognome, String email, String password) {
        super(id, nome, cognome, email, password);
    }

    public Team creaTeam(Hackathon hackathon, String nomeTeam) {
        Team team = new Team(null, nomeTeam, hackathon, this);
        System.out.println("Team " + nomeTeam + " creato da " + getEmail());
        return team;
    }

    public Invito invitaMembro(Utente utente, Team team) {
        Invito invito = new Invito(null, this, utente, team);
        System.out.println("Invito inviato a " + utente.getEmail());
        return invito;
    }

    public void inviaSottomissione(Hackathon hackathon, String link) {
        System.out.println("Sottomissione inviata per l'hackathon " + hackathon.getNome());
    }
}