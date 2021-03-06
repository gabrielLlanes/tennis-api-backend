package com.example.tennisBackendCode.controllers;

import com.example.tennisBackendCode.miscTools.requestBodies.Head2Head;
import com.example.tennisBackendCode.model.DailyMatch;
import com.example.tennisBackendCode.model.DailyMatchID;
import com.example.tennisBackendCode.model.DailyMatches;
import com.example.tennisBackendCode.model.Match;
import com.example.tennisBackendCode.model.Player;
import com.example.tennisBackendCode.model.PlayerActivitySingleTournament;
import com.example.tennisBackendCode.model.PlayerRank;
import com.example.tennisBackendCode.model.PlayerStatistics;
import com.example.tennisBackendCode.services.TennisService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TennisRestController {

    private final TennisService tennisService;

    public TennisRestController(TennisService tennisService) {this.tennisService = tennisService;}

    @GetMapping("/helloworld")
    public String sayHello() {
        return "hello";
    }

    @GetMapping("/api/matches")
    public List<Match> getAllMatches() {
        return tennisService.getAllMatches();
    }

    @PostMapping("/api/h2hmatches")
    public List<Match> getMatchesByPlayerNames(@RequestBody Head2Head h2h) {
        return tennisService.getMatchesByPlayerNames(h2h.getP1(), h2h.getP2());
    }

    @GetMapping("/api/playerstats")
    public PlayerStatistics getPlayerStatisticsByName(@RequestParam("Player Name") String playerName) {
        return tennisService.getPlayerStatisticsByName(playerName);
    }

    @GetMapping("/api/playeractivity")
    public List<PlayerActivitySingleTournament> getPlayerActivity(@RequestParam("Player Name") String playerName) {
        return tennisService.getPlayerActivity(playerName);
    }
    @GetMapping("/api/rankings")
    public List<PlayerRank> getRankings() {
        return tennisService.getRankings();
    }

    @PostMapping("/api/insertplayers")
    public void insertPlayers(@RequestBody Player[] players) {
        tennisService.insertPlayers(players);
    }
    @GetMapping("/api/dailysummary")
    public DailyMatches getDailyMatches(@RequestParam("date") java.sql.Date date) {
        return tennisService.getDailyMatchesGet(date);
    }
    @PostMapping("/api/dailysummary")
    public DailyMatches getDailyMatches(@RequestBody DailyMatchID[] matches, @RequestParam("date") java.sql.Date date) {
        for(DailyMatchID match : matches) {
            match.setMatchDate(date);
        }
        return tennisService.getDailyMatchesPost(matches, date);
    }

    @GetMapping("/api/playernames")
    public List<String> getAllPlayerNames() {
        return tennisService.getAllPlayerNames();
    }

    @GetMapping("/api/calculateallstats")
    public String calculateAllStatistics() {
        java.util.Date before = new java.util.Date();
        tennisService.calculateAllStatistics();
        java.util.Date after = new java.util.Date();
        return String.format("Calculated statistics and updated database in %d ms.", after.getTime() - before.getTime());
    }
}
