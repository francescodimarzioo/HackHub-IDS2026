package com.hackhub.controller;

import com.hackhub.model.*;
import com.hackhub.service.*;
import com.hackhub.validator.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @Autowired
    private TeamValidator teamValidator;

    @PostMapping("/crea")
    public ResponseEntity<Team> creaTeam(@RequestParam Long idHackathon,
                                         @RequestParam String nomeTeam,
                                         @RequestParam Long idLeader) {
        teamValidator.validateInputCreaTeam(idHackathon, nomeTeam, idLeader);
        LeaderTeam leader = new LeaderTeam();
        leader.setId(idLeader);
        return ResponseEntity.ok(teamService.creaTeam(idHackathon, nomeTeam, leader));
    }

    @PostMapping("/iscrivi")
    public ResponseEntity<Team> iscriviTeam(@RequestParam Long idTeam,
                                            @RequestParam Long idHackathon,
                                            @RequestParam Long idLeader) {
        teamValidator.validateInputIscriviTeam(idTeam, idHackathon, idLeader);
        return ResponseEntity.ok(teamService.iscriviTeam(idTeam, idHackathon, idLeader));
    }

    @DeleteMapping("/{idTeam}/abbandona")
    public ResponseEntity<Team> abbandonaTeam(@PathVariable Long idTeam,
                                              @RequestParam Long idMembroTeam) {
        return ResponseEntity.ok(teamService.abbandonaTeam(idTeam, idMembroTeam));
    }
}