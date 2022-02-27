package com.example.tennisBackendCode.model;
import java.sql.Date;
public class Match{
    private Date tourneyDate;
    private String tourneyName;
    private String surface;
    private String round;
    private String winnerName;
    private short winnerRank;
    private String loserName;
    private short loserRank;
    private String score;

    public Match(Date tourneyDate,
                 String tourneyName,
                 String surface,
                 String round,
                 String winnerName,
                 short winnerRank,
                 String loserName,
                 short loserRank,
                 String score) {
        this.tourneyDate = tourneyDate;
        this.tourneyName = tourneyName;
        this.surface = surface;
        this.round = round;
        this.winnerName = winnerName;
        this.winnerRank = winnerRank;
        this.loserName = loserName;
        this.loserRank = loserRank;
        this.score = score;
    }

    @Override
    public boolean equals(Object match) {
        Match m = (Match)match;
        return m.getTourneyDate().equals(tourneyDate) &&
                m.getTourneyName().equals(tourneyName) &&
                m.getSurface().equals(surface) &&
                m.getRound().equals(round) &&
                m.getWinnerName().equals(winnerName) &&
                m.getLoserName().equals(loserName) &&
                m.getScore().equals(score);
    }

    @Override
    public int hashCode() {
        String matchString = tourneyDate.toString() +
                tourneyName + surface + round + winnerName +
                loserName + score;
        return matchString.hashCode();
    }

    @Override
    public String toString() {
       return String.format("Round: %s, Winner: %s, Loser: %s, Score: %s\n",
                round, winnerName, loserName, score);
    }
    public void setTourneyDate(Date tourneyDate) {
        this.tourneyDate = tourneyDate;
    }

    public Date getTourneyDate() {
        return tourneyDate;
    }

    public void setTourneyName(String tourneyName) {
        this.tourneyName = tourneyName;
    }

    public String getTourneyName() {
        return tourneyName;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public String getSurface() {
        return surface;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public String getRound() {
        return round;
    }

    public void setWinnerName(String winnerName) {
        this.winnerName = winnerName;
    }

    public String getWinnerName() {
        return winnerName;
    }

    public void setWinnerRank(short winnerRank) {
        this.winnerRank = winnerRank;
    }

    public short getWinnerRank() {
        return winnerRank;
    }

    public void setLoserName(String loserName) {
        this.loserName = loserName;
    }

    public String getLoserName() {
        return loserName;
    }

    public void setLoserRank(short loserRank) {
        this.loserRank = loserRank;
    }

    public short getLoserRank() {
        return loserRank;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getScore() {
        return score;
    }
}
