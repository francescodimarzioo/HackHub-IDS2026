package com.hackhub.dto;

public class CreaTeamRequest {

    private Long idHackathon;
    private String nomeTeam;
    private Long idLeader;

    public CreaTeamRequest(Long idHackathon, String nomeTeam, Long idLeader) {
        this.idHackathon = idHackathon;
        this.nomeTeam = nomeTeam;
        this.idLeader = idLeader;
    }

    public Long getIdHackathon() {
        return idHackathon;
    }

    public void setIdHackathon(Long idHackathon) {
        this.idHackathon = idHackathon;
    }

    public String getNomeTeam() {
        return nomeTeam;
    }

    public void setNomeTeam(String nomeTeam) {
        this.nomeTeam = nomeTeam;
    }

    public Long getIdLeader() {
        return idLeader;
    }

    public void setIdLeader(Long idLeader) {
        this.idLeader = idLeader;
    }
}