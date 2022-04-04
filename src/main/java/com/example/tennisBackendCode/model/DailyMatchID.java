package com.example.tennisBackendCode.model;

public class DailyMatchID {
    private java.sql.Date matchDate;
    private String tourneyName;
    private int homeID;
    private int awayID;
    private int winnerID;
    private String score;
    String round;

    public DailyMatchID(java.sql.Date matchDate, String tourneyName, int homeID, int awayID, int winnerID,
    String score, String round) {
        this.matchDate=matchDate;
        this.tourneyName=tourneyName;
        this.homeID = homeID;
        this.awayID = awayID;
        this.winnerID = winnerID;
        this.score=score;
        this.round=round;
    }

    public DailyMatchID() {}

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
    public void setHomeID(int homeID) {
        this.homeID = homeID;
    }
    public int getHomeID() {
        return homeID;
    }
    public void setAwayID(int awayID) {
        this.awayID = awayID;
    }
    public int getAwayID() {
        return awayID;
    }
    public void setWinnerID(int winnerID) {
        this.winnerID = winnerID;
    }
    public int getWinnerID() {
        return winnerID;
    }
    public void setScore(String score) {
        this.score = score;
    }
    public String getScore() {
        return score;
    }
    public void setRound(String round) {
        this.round = round;
    }
    public String getRound() {
        return round;
    }
    public String toString() {
        return matchDate.toString() + tourneyName + homeID + awayID + winnerID + score;
    }
}
