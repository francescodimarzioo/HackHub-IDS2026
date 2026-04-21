package com.hackhub.validator;

import com.hackhub.model.*;
import com.hackhub.dto.*;

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
    public void validateNomeTeam(String nomeTeam) {
        if (nomeTeam.length() < 3) {
            throw new IllegalArgumentException("Nome team deve essere di almeno 3 caratteri");
        }
        if (nomeTeam.length() > 50) {
            throw new IllegalArgumentException("Nome team non può superare i 50 caratteri");
        }
        System.out.println("Nome team validato correttamente.");
    }
}