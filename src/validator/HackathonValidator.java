package validator;

public class HackathonValidator {

    public void validateInputCreaHackathon(String nome, String regolamento,
                                           String luogo, Double premioInDenaro,
                                           int dimensioneMaxTeam, Long idOrganizzatore) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome non può essere null o vuoto");
        }
        if (regolamento == null || regolamento.isEmpty()) {
            throw new IllegalArgumentException("Regolamento non può essere null o vuoto");
        }
        if (luogo == null || luogo.isEmpty()) {
            throw new IllegalArgumentException("Luogo non può essere null o vuoto");
        }
        if (premioInDenaro == null || premioInDenaro < 0) {
            throw new IllegalArgumentException("Premio non valido");
        }
        if (dimensioneMaxTeam <= 0) {
            throw new IllegalArgumentException("Dimensione massima team non valida");
        }
        if (idOrganizzatore == null) {
            throw new IllegalArgumentException("idOrganizzatore non può essere null");
        }
        System.out.println("Input creaHackathon validato correttamente.");
    }

    public void validateInputAvviaFase(Long idHackathon, Long idOrganizzatore) {
        if (idHackathon == null) {
            throw new IllegalArgumentException("idHackathon non può essere null");
        }
        if (idOrganizzatore == null) {
            throw new IllegalArgumentException("idOrganizzatore non può essere null");
        }
        System.out.println("Input avviaFase validato correttamente.");
    }
}