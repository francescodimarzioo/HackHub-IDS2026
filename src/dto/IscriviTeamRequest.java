package dto;

public class IscriviTeamRequest {

    private Long idTeam;
    private Long idHackathon;
    private Long idLeader;

    public IscriviTeamRequest(Long idTeam, Long idHackathon, Long idLeader) {
        this.idTeam = idTeam;
        this.idHackathon = idHackathon;
        this.idLeader = idLeader;
    }

    public Long getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(Long idTeam) {
        this.idTeam = idTeam;
    }

    public Long getIdHackathon() {
        return idHackathon;
    }

    public void setIdHackathon(Long idHackathon) {
        this.idHackathon = idHackathon;
    }

    public Long getIdLeader() {
        return idLeader;
    }

    public void setIdLeader(Long idLeader) {
        this.idLeader = idLeader;
    }
}