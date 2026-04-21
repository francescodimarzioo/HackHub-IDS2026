package com.hackhub.pattern;

import com.hackhub.model.Team;

public class PagamentoFacade {

    public void erogaPremio(Team team, Double importo) {
        System.out.println("Premio di " + importo + "€ erogato al team " + team.getNome());
    }
}