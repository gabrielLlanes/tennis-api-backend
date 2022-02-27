package com.example.tennisBackendCode.model;

public class PlayerActivitySingleTournamentMatch {
    private String round;
    private String opponent;
    private String result;
    private String score;

    public PlayerActivitySingleTournamentMatch(
                       String round, String opponent,
                       String result, String score) {
        this.round=round;
        this.opponent=opponent;
        this.result=result;
        this.score=score;
    }

    @Override
    public String toString() {
        return String.format("Round: %s, Opponent: %s, Result: %s, Score: %s\n",
                round, opponent, result, score);
    }

    public void setRound(String round) {
        this.round = round;
    }

    public String getRound() {
        return round;
    }

    public void setOpponent(String opponent) {
        this.opponent = opponent;
    }

    public String getOpponent() {
        return opponent;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getScore() {
        return score;
    }
}
