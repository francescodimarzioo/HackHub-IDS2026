package validator;

public class SottomissioneValidator {

    public void validateInputInvia(Long idTeam, Long idHackathon,
                                   String link, Long idLeader) {
        if (idTeam == null) {
            throw new IllegalArgumentException("idTeam non può essere null");
        }
        if (idHackathon == null) {
            throw new IllegalArgumentException("idHackathon non può essere null");
        }
        if (link == null || link.isEmpty()) {
            throw new IllegalArgumentException("link non può essere null o vuoto");
        }
        if (idLeader == null) {
            throw new IllegalArgumentException("idLeader non può essere null");
        }
        System.out.println("Input inviaSottomissione validato correttamente.");
    }

    public void validateInputAggiorna(Long idSottomissione,
                                      String nuovoLink, Long idLeader) {
        if (idSottomissione == null) {
            throw new IllegalArgumentException("idSottomissione non può essere null");
        }
        if (nuovoLink == null || nuovoLink.isEmpty()) {
            throw new IllegalArgumentException("nuovoLink non può essere null o vuoto");
        }
        if (idLeader == null) {
            throw new IllegalArgumentException("idLeader non può essere null");
        }
        System.out.println("Input aggiornaSottomissione validato correttamente.");
    }
}