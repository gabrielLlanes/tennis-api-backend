package com.example.tennisBackendCode.model;

public class Player {
    private int playerID;
    private String playerName;
    private String country;

    public Player(int playerID, String playerName, String country) {
        this.playerID=playerID;this.playerName=playerName;this.country=country;
    }
    public Player(){}

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }
    public int getPlayerID() {
        return playerID;
    }
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    public String getPlayerName() {
        return playerName;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getCountry() {
        return country;
    }
}
