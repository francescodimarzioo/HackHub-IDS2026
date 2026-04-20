package model;

public class Invito {

    private Long id;
    private Utente mittente;
    private Utente destinatario;
    private Team team;
    private String stato;

    public Invito(Long id, Utente mittente, Utente destinatario, Team team) {
        this.id = id;
        this.mittente = mittente;
        this.destinatario = destinatario;
        this.team = team;
        this.stato = "IN_ATTESA";
    }

    public void accetta() {
        this.stato = "ACCETTATO";
        System.out.println("Invito accettato da " + destinatario.getEmail());
    }

    public void rifiuta() {
        this.stato = "RIFIUTATO";
        System.out.println("Invito rifiutato da " + destinatario.getEmail());
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Utente getMittente() { return mittente; }
    public void setMittente(Utente mittente) { this.mittente = mittente; }
    public Utente getDestinatario() { return destinatario; }
    public void setDestinatario(Utente destinatario) { this.destinatario = destinatario; }
    public Team getTeam() { return team; }
    public void setTeam(Team team) { this.team = team; }
    public String getStato() { return stato; }
    public void setStato(String stato) { this.stato = stato; }
}
