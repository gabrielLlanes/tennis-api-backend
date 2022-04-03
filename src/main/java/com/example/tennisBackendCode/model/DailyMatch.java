package com.example.tennisBackendCode.model;

public class DailyMatch {
    java.sql.Date matchDate;
    String tourneyName;
    String homePlayer;
    String awayPlayer;
    String winnerName;
    String score;

    public DailyMatch(java.sql.Date matchDate, String tourneyName, String homePlayer, String awayPlayer,
    String winnerName, String score) {
        this.matchDate=matchDate;
        this.tourneyName=tourneyName;this.homePlayer=homePlayer;this.awayPlayer=awayPlayer;this.winnerName=winnerName;
        this.score=score;
    }
    public DailyMatch() {}

    public void setMatchDate(java.sql.Date matchDate) {
        this.matchDate=matchDate;
    }
    public java.sql.Date getMatchDate() {
        return matchDate;
    }
    
    public void setTourneyName(String tourneyName) {
        this.tourneyName = tourneyName;
    }
    public String getTourneyName() {
        return tourneyName;
    }
    public void setHomePlayer(String homePlayer) {
        this.homePlayer = homePlayer;
    }
    public String getHomePlayer() {
        return homePlayer;
    }
    public void setAwayPlayer(String awayPlayer) {
        this.awayPlayer = awayPlayer;
    }
    public String getAwayPlayer() {
        return awayPlayer;
    }
    public void setWinnerName(String winnerName) {
        this.winnerName = winnerName;
    }
    public String getWinnerName() {
        return winnerName;
    }
    public void setScore(String score) {
        this.score = score;
    }
    public String getScore() {
        return score;
    }
    public String toString() {
        return matchDate.toString() + " " + tourneyName + " " + homePlayer+ " "  + awayPlayer + " " + winnerName + " " + score;
    }
}
