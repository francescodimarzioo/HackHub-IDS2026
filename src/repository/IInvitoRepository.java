package repository;

import model.Invito;

public interface IInvitoRepository {

    Invito findById(Long id);
    Invito save(Invito invito);
}