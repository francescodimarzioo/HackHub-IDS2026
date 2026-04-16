package repository;

import model.Utente;

public interface IUtenteRepository {

    Utente findById(Long id);

    Utente findByEmail(String email);

    Utente save(Utente utente);
}