package com.hackhub.validator;

import com.hackhub.model.*;
import com.hackhub.dto.*;

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

    public void validateInputProclamaVincitore(Long idHackathon, Long idTeamVincitore, Long idOrganizzatore) {
        if (idHackathon == null) {
            throw new IllegalArgumentException("idHackathon non può essere null");
        }
        if (idTeamVincitore == null) {
            throw new IllegalArgumentException("idTeamVincitore non può essere null");
        }
        if (idOrganizzatore == null) {
            throw new IllegalArgumentException("idOrganizzatore non può essere null");
        }
        System.out.println("Input proclamaVincitore validato correttamente.");
    }

    public void validateInputModificaHackathon(Long idHackathon, Long idOrganizzatore) {
        if (idHackathon == null) {
            throw new IllegalArgumentException("idHackathon non può essere null");
        }
        if (idOrganizzatore == null) {
            throw new IllegalArgumentException("idOrganizzatore non può essere null");
        }
        System.out.println("Input modificaHackathon validato correttamente.");
    }

    public void validateInputAggiungiMentore(Long idHackathon, Long idMentore, Long idOrganizzatore) {
        if (idHackathon == null) {
            throw new IllegalArgumentException("idHackathon non può essere null");
        }
        if (idMentore == null) {
            throw new IllegalArgumentException("idMentore non può essere null");
        }
        if (idOrganizzatore == null) {
            throw new IllegalArgumentException("idOrganizzatore non può essere null");
        }
        System.out.println("Input aggiungiMentore validato correttamente.");
    }
}