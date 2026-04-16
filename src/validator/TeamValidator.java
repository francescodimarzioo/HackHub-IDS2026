package validator;

public class TeamValidator {

    public void validateInputCreaTeam(Long idHackathon, String nomeTeam, Long idLeader) {
        if (idHackathon == null) {
            throw new IllegalArgumentException("idHackathon non può essere null");
        }
        if (nomeTeam == null || nomeTeam.isEmpty()) {
            throw new IllegalArgumentException("nomeTeam non può essere null o vuoto");
        }
        if (idLeader == null) {
            throw new IllegalArgumentException("idLeader non può essere null");
        }
        System.out.println("Input creaTeam validato correttamente.");
    }

    public void validateInputIscriviTeam(Long idTeam, Long idHackathon, Long idLeader) {
        if (idTeam == null) {
            throw new IllegalArgumentException("idTeam non può essere null");
        }
        if (idHackathon == null) {
            throw new IllegalArgumentException("idHackathon non può essere null");
        }
        if (idLeader == null) {
            throw new IllegalArgumentException("idLeader non può essere null");
        }
        System.out.println("Input iscriviTeam validato correttamente.");
    }
}