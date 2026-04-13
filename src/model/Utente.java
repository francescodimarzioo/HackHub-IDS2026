package model;

import java.time.LocalDateTime;

public class Utente {

    private Long id;
    private String nome;
    private String cognome;
    private String email;
    private String password;
    private LocalDateTime dataRegistrazione;

    public Utente(Long id, String nome, String cognome, String email, String password) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.password = password;
        this.dataRegistrazione = LocalDateTime.now();
    }

    public void registrati() {
        System.out.println("Utente " + email + " registrato.");
    }

    public void login() {
        System.out.println("Utente " + email + " ha effettuato il login.");
    }

    public void logout() {
        System.out.println("Utente " + email + " ha effettuato il logout.");
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCognome() { return cognome; }
    public void setCognome(String cognome) { this.cognome = cognome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public LocalDateTime getDataRegistrazione() { return dataRegistrazione; }
}