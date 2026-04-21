package com.hackhub.dto;

public class CreaInvitoRequest {

    private Long idTeam;
    private Long idDestinatario;
    private Long idLeader;

    public CreaInvitoRequest(Long idTeam, Long idDestinatario, Long idLeader) {
        this.idTeam = idTeam;
        this.idDestinatario = idDestinatario;
        this.idLeader = idLeader;
    }

    public Long getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(Long idTeam) {
        this.idTeam = idTeam;
    }

    public Long getIdDestinatario() {
        return idDestinatario;
    }

    public void setIdDestinatario(Long idDestinatario) {
        this.idDestinatario = idDestinatario;
    }

    public Long getIdLeader() {
        return idLeader;
    }

    public void setIdLeader(Long idLeader) {
        this.idLeader = idLeader;
    }
}