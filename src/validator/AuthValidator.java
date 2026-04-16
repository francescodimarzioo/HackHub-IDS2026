package validator;

public class AuthValidator {

    public void validateRegistrazione(String nome, String cognome,
                                      String email, String password) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome non può essere null o vuoto");
        }
        if (cognome == null || cognome.isEmpty()) {
            throw new IllegalArgumentException("Cognome non può essere null o vuoto");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Email non valida");
        }
        if (password == null || password.length() < 6) {
            throw new IllegalArgumentException("Password deve essere di almeno 6 caratteri");
        }
        System.out.println("Input registrazione validato correttamente.");
    }

    public void validateLogin(String email, String password) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Email non valida");
        }
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password non può essere null o vuota");
        }
        System.out.println("Input login validato correttamente.");
    }
}