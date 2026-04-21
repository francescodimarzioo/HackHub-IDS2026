package com.hackhub.dto;

public class RispostaInvitoRequest {

    private Long idInvito;
    private String risposta;
    private Long idUtente;

    public RispostaInvitoRequest(Long idInvito, String risposta, Long idUtente) {
        this.idInvito = idInvito;
        this.risposta = risposta;
        this.idUtente = idUtente;
    }

    public Long getIdInvito() {
        return idInvito;
    }

    public void setIdInvito(Long idInvito) {
        this.idInvito = idInvito;
    }

    public String getRisposta() {
        return risposta;
    }

    public void setRisposta(String risposta) {
        this.risposta = risposta;
    }

    public Long getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(Long idUtente) {
        this.idUtente = idUtente;
    }
}