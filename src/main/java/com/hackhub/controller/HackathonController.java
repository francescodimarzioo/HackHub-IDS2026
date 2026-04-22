package com.hackhub.controller;

import com.hackhub.model.*;
import com.hackhub.service.*;
import com.hackhub.validator.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/hackathon")
public class HackathonController {

    @Autowired
    private HackathonService hackathonService;

    @Autowired
    private HackathonValidator hackathonValidator;

    @PostMapping("/crea")
    public ResponseEntity<Hackathon> creaHackathon(@RequestParam String nome,
                                                   @RequestParam String regolamento,
                                                   @RequestParam String luogo,
                                                   @RequestParam Double premioInDenaro,
                                                   @RequestParam int dimensioneMaxTeam,
                                                   @RequestParam Long idOrganizzatore) {
        hackathonValidator.validateInputCreaHackathon(nome, regolamento, luogo,
                premioInDenaro, dimensioneMaxTeam, idOrganizzatore);
        Organizzatore organizzatore = new Organizzatore();
        organizzatore.setId(idOrganizzatore);
        return ResponseEntity.ok(hackathonService.creaHackathon(nome, regolamento, luogo,
                premioInDenaro, dimensioneMaxTeam, organizzatore));
    }

    @PutMapping("/{idHackathon}/avvia-iscrizione")
    public ResponseEntity<Hackathon> avviaFaseIscrizione(@PathVariable Long idHackathon,
                                                         @RequestParam Long idOrganizzatore) {
        hackathonValidator.validateInputAvviaFase(idHackathon, idOrganizzatore);
        return ResponseEntity.ok(hackathonService.avviaFaseIscrizione(idHackathon, idOrganizzatore));
    }

    @PutMapping("/{idHackathon}/concludi-iscrizione")
    public ResponseEntity<Hackathon> concludiFaseIscrizione(@PathVariable Long idHackathon,
                                                            @RequestParam Long idOrganizzatore) {
        hackathonValidator.validateInputAvviaFase(idHackathon, idOrganizzatore);
        return ResponseEntity.ok(hackathonService.concludiFaseIscrizione(idHackathon, idOrganizzatore));
    }

    @PutMapping("/{idHackathon}/avvia-svolgimento")
    public ResponseEntity<Hackathon> avviaFaseSvolgimento(@PathVariable Long idHackathon,
                                                          @RequestParam Long idOrganizzatore) {
        hackathonValidator.validateInputAvviaFase(idHackathon, idOrganizzatore);
        return ResponseEntity.ok(hackathonService.avviaFaseSvolgimento(idHackathon, idOrganizzatore));
    }

    @PutMapping("/{idHackathon}/concludi-svolgimento")
    public ResponseEntity<Hackathon> concludiFaseSvolgimento(@PathVariable Long idHackathon,
                                                             @RequestParam Long idOrganizzatore) {
        hackathonValidator.validateInputAvviaFase(idHackathon, idOrganizzatore);
        return ResponseEntity.ok(hackathonService.concludiFaseSvolgimento(idHackathon, idOrganizzatore));
    }

    @PutMapping("/{idHackathon}/proclama-vincitore")
    public ResponseEntity<Hackathon> proclamaVincitore(@PathVariable Long idHackathon,
                                                       @RequestParam Long idTeamVincitore,
                                                       @RequestParam Long idOrganizzatore) {
        hackathonValidator.validateInputProclamaVincitore(idHackathon, idTeamVincitore, idOrganizzatore);
        return ResponseEntity.ok(hackathonService.proclamaVincitore(idHackathon, idTeamVincitore, idOrganizzatore));
    }

    @PostMapping("/{idHackathon}/eroga-premio")
    public ResponseEntity<Void> erogaPremio(@PathVariable Long idHackathon) {
        hackathonService.erogaPremio(idHackathon);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{idHackathon}/modifica")
    public ResponseEntity<Hackathon> modificaHackathon(@PathVariable Long idHackathon,
                                                       @RequestParam String nome,
                                                       @RequestParam String regolamento,
                                                       @RequestParam String luogo,
                                                       @RequestParam Double premioInDenaro,
                                                       @RequestParam int dimensioneMaxTeam,
                                                       @RequestParam Long idOrganizzatore) {
        hackathonValidator.validateInputModificaHackathon(idHackathon, idOrganizzatore);
        return ResponseEntity.ok(hackathonService.modificaHackathon(idHackathon, nome, regolamento,
                luogo, premioInDenaro, dimensioneMaxTeam, idOrganizzatore));
    }

    @GetMapping
    public ResponseEntity<List<Hackathon>> getElencoHackathon() {
        return ResponseEntity.ok(hackathonService.getElencoHackathon());
    }

    @GetMapping("/{idHackathon}")
    public ResponseEntity<Hackathon> getDettaglioHackathon(@PathVariable Long idHackathon) {
        return ResponseEntity.ok(hackathonService.getDettaglioHackathon(idHackathon));
    }

    @GetMapping("/{idHackathon}/regolamento")
    public ResponseEntity<String> getRegolamentoHackathon(@PathVariable Long idHackathon) {
        return ResponseEntity.ok(hackathonService.getRegolamentoHackathon(idHackathon));
    }
}