package com.example.tennisBackendCode.services;

import com.example.tennisBackendCode.miscTools.comparators.SingleTournamentMatchComparator;
import com.example.tennisBackendCode.model.DailyMatch;
import com.example.tennisBackendCode.model.DailyMatchID;
import com.example.tennisBackendCode.model.Match;
import com.example.tennisBackendCode.model.Player;
import com.example.tennisBackendCode.model.PlayerActivitySingleTournament;
import com.example.tennisBackendCode.model.PlayerActivitySingleTournamentMatch;
import com.example.tennisBackendCode.model.PlayerRank;
import com.example.tennisBackendCode.model.PlayerStatistics;
import com.example.tennisBackendCode.repositories.TennisRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TennisService {
    private final TennisRepo tennisRepo;

    @Autowired
    public TennisService(TennisRepo tennisRepo) {
        this.tennisRepo = tennisRepo;
    }

    public List<Match> getAllMatches() {
        return tennisRepo.getAllMatches();
    }

    public List<Match> getMatchesByPlayerNames(String player1, String player2) {
        return tennisRepo.getMatchesByPlayerNames(player1, player2);
    }

    public PlayerStatistics getPlayerStatisticsByName(String playerName) {
        return tennisRepo.getPlayerStatisticsByName(playerName);
    }


    public ArrayList<PlayerActivitySingleTournament> getPlayerActivity(String playerName) {
        ArrayList<PlayerActivitySingleTournament> playerActivity = new ArrayList<>();
        ArrayList<Match> matches = tennisRepo.getAllMatchesByPlayer(playerName);
        ArrayList<PlayerActivitySingleTournamentMatch> currTourneyMatches = new ArrayList<>();

        matches.forEach(match -> {
            //System.out.println(match);
            boolean playerIsWinner = playerName.compareToIgnoreCase(match.getWinnerName()) == 0 ? true : false;
            String result = playerIsWinner ? "W" : "L";
            String opponent = playerIsWinner ? match.getLoserName() : match.getWinnerName();
            String round = match.getRound();
            String score = match.getScore();
                if(matches.indexOf(match) == 0)  {
                    currTourneyMatches.add(new PlayerActivitySingleTournamentMatch(
                            round, opponent, result, score
                    ));
                }
                else if(match.getTourneyName().equals(matches.get(matches.indexOf(match) - 1).getTourneyName())){
                    currTourneyMatches.add(new PlayerActivitySingleTournamentMatch(
                            round, opponent, result, score));
                }
                else {
                    Match prevMatch = matches.get(matches.indexOf(match) - 1);
                    playerActivity.add(new PlayerActivitySingleTournament(
                            prevMatch.getTourneyName(),
                            prevMatch.getTourneyDate(),
                            prevMatch.getSurface(),
                            prevMatch.getWinnerName().compareToIgnoreCase(playerName) == 0 ? prevMatch.getWinnerRank() : prevMatch.getLoserRank(),
                            new ArrayList<PlayerActivitySingleTournamentMatch>(currTourneyMatches)));
                    currTourneyMatches.clear();
                    currTourneyMatches.add(new PlayerActivitySingleTournamentMatch(
                            round, opponent, result, score));
                }
        });
        playerActivity.forEach(singleTournamentActivity -> {
            singleTournamentActivity.getMatches().sort(new SingleTournamentMatchComparator());
        });
        return playerActivity;
    }
    public void insertPlayers(Player[] players) {
        tennisRepo.insertPlayers(players);
    }
    public List<DailyMatch> getDailyMatchesGet(java.sql.Date date) {
        return tennisRepo.getDailyMatchesGet(date);
    }
    public List<DailyMatch> getDailyMatchesPost(DailyMatchID[] matches, java.sql.Date date) {
        return tennisRepo.getDailyMatchesPost(matches, date);
    } 
    public List<PlayerRank> getRankings() {
        return tennisRepo.getRankings();
    }

    public void calculateAllStatistics() {
        tennisRepo.calculateAllStatistics();
    }

    public ArrayList<String> getAllPlayerNames() {
        return tennisRepo.getAllPlayerNames();
    }

}
