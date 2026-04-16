package validator;

public class InvitoValidator {

    public void validateInputUtente(Long idTeam, Long idDestinatario, Long idLeader) {
        if (idTeam == null) {
            throw new IllegalArgumentException("idTeam non può essere null");
        }
        if (idDestinatario == null) {
            throw new IllegalArgumentException("idDestinatario non può essere null");
        }
        if (idLeader == null) {
            throw new IllegalArgumentException("idLeader non può essere null");
        }
        System.out.println("Input validato correttamente.");
    }

    public void validateInputRisposta(Long idInvito, String risposta, Long idUtente) {
        if (idInvito == null) {
            throw new IllegalArgumentException("idInvito non può essere null");
        }
        if (risposta == null || risposta.isEmpty()) {
            throw new IllegalArgumentException("risposta non può essere null o vuota");
        }
        if (!risposta.equals("ACCETTATO") && !risposta.equals("RIFIUTATO")) {
            throw new IllegalArgumentException("risposta deve essere ACCETTATO o RIFIUTATO");
        }
        if (idUtente == null) {
            throw new IllegalArgumentException("idUtente non può essere null");
        }
        System.out.println("Input risposta validato correttamente.");
    }
}