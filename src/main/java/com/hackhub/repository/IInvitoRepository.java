package com.hackhub.repository;

import com.hackhub.model.*;

import com.hackhub.model.Invito;

public interface IInvitoRepository {

    Invito findById(Long id);
    Invito save(Invito invito);
}