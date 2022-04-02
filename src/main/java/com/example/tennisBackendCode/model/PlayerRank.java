package com.example.tennisBackendCode.model;

public class PlayerRank {
    private Short playerRank;
    private String playerName;
    private Integer playerPoints;

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    public String getPlayerName() {
        return playerName;
    }
    public void setPlayerRank(Short playerRank) {
        this.playerRank = playerRank;
    }
    public Short getPlayerRank() {
        return playerRank;
    }
    public void setPlayerPoints(Integer playerPoints) {
        this.playerPoints = playerPoints;
    }
    public Integer getPlayerPoints() {
        return playerPoints;
    }
    public PlayerRank(Short playerRank, String playerName, Integer playerPoints) {
        this.playerName=playerName;this.playerRank=playerRank;this.playerPoints=playerPoints;
    }
}

