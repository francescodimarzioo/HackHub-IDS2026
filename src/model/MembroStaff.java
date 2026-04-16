package model;

public class MembroStaff extends Utente {

    private String bio;
    private String linkProfilo;

    public MembroStaff(Long id, String nome, String cognome, String email, String password, String bio, String linkProfilo) {
        super(id, nome, cognome, email, password);
        this.bio = bio;
        this.linkProfilo = linkProfilo;
    }

    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }
    public String getLinkProfilo() { return linkProfilo; }
    public void setLinkProfilo(String linkProfilo) { this.linkProfilo = linkProfilo; }
}