package com.example.tennisBackendCode.model;

import java.math.BigDecimal;

public class PlayerStatistics {
    private short careerWins;
    private short careerLosses;
    private int totalAces;
    private int totalDoubleFaults;
    private BigDecimal firstServeMadePct;
    private BigDecimal firstServeWonPct;
    private BigDecimal secondServeWonPct;
    private int breakPointsFaced;
    private BigDecimal breakPointsSavedPct;
    private int serviceGamesPlayed;
    private BigDecimal serviceGamesWonPct;
    private BigDecimal servicePointsWonPct;
    private BigDecimal returnFirstServeWonPct;
    private BigDecimal returnSecondServeWonPct;
    private int breakPointOpportunities;
    private BigDecimal breakPointsConvertedPct;
    private int returnGamesPlayed;
    private BigDecimal returnGamesWonPct;
    private BigDecimal returnPointsWonPct;
    private BigDecimal totalPointsWonPct;

    public PlayerStatistics(short careerWins, short careerLosses, int totalAces, int totalDoubleFaults, BigDecimal firstServeMadePct,
                            BigDecimal firstServeWonPct, BigDecimal secondServeWonPct,
                            int breakPointsFaced, BigDecimal breakPointsSavedPct, int serviceGamesPlayed,
                            BigDecimal serviceGamesWonPct, BigDecimal servicePointsWonPct,
                            BigDecimal returnFirstServeWonPct, BigDecimal returnSecondServeWonPct,
                            int breakPointOpportunities, BigDecimal breakPointsConvertedPct, int returnGamesPlayed,
                            BigDecimal returnGamesWonPct, BigDecimal returnPointsWonPct, BigDecimal totalPointsWonPct) {
        this.careerWins=careerWins;this.careerLosses=careerLosses;
        this.totalAces = totalAces; this.totalDoubleFaults = totalDoubleFaults; this.firstServeMadePct = firstServeMadePct;
        this.firstServeWonPct=firstServeWonPct;this.secondServeWonPct=secondServeWonPct;this.breakPointsFaced=breakPointsFaced;
        this.breakPointsSavedPct=breakPointsSavedPct; this.serviceGamesPlayed=serviceGamesPlayed; this.serviceGamesWonPct=serviceGamesWonPct;
        this.servicePointsWonPct=servicePointsWonPct; this.returnFirstServeWonPct = returnFirstServeWonPct;this.returnSecondServeWonPct=returnSecondServeWonPct;
        this.breakPointOpportunities=breakPointOpportunities;this.breakPointsConvertedPct=breakPointsConvertedPct;this.returnGamesPlayed=returnGamesPlayed;
        this.returnGamesWonPct=returnGamesWonPct;this.returnPointsWonPct=returnPointsWonPct;this.totalPointsWonPct=totalPointsWonPct;


    }

    public PlayerStatistics() {
        this.careerWins = -1;
    }

    public void setCareerWins(short careerWins) {
        this.careerWins = careerWins;
    }

    public short getCareerWins() {
        return careerWins;
    }

    public void setCareerLosses(short careerLosses) {
        this.careerLosses = careerLosses;
    }

    public short getCareerLosses() {
        return careerLosses;
    }

    public void setTotalAces(int totalAces) {
        this.totalAces = totalAces;
    }

    public int getTotalAces() {
        return totalAces;
    }

    public void setTotalDoubleFaults(int totalDoubleFaults) {
        this.totalDoubleFaults = totalDoubleFaults;
    }

    public int getTotalDoubleFaults() {
        return totalDoubleFaults;
    }

    public void setFirstServeMadePct(BigDecimal firstServeMadePct) {
        this.firstServeMadePct = firstServeMadePct;
    }

    public BigDecimal getFirstServeMadePct() {
        return firstServeMadePct;
    }

    public void setFirstServeWonPct(BigDecimal firstServeWonPct) {
        this.firstServeWonPct = firstServeWonPct;
    }

    public BigDecimal getFirstServeWonPct() {
        return firstServeWonPct;
    }

    public void setSecondServeWonPct(BigDecimal secondServeWonPct) {
        this.secondServeWonPct = secondServeWonPct;
    }

    public BigDecimal getSecondServeWonPct() {
        return secondServeWonPct;
    }


    public void setBreakPointsFaced(int breakPointsFaced) {
        this.breakPointsFaced = breakPointsFaced;
    }

    public void setBreakPointsSavedPct(BigDecimal breakPointsSavedPct) {
        this.breakPointsSavedPct = breakPointsSavedPct;
    }

    public void setServiceGamesPlayed(int serviceGamesPlayed) {
        this.serviceGamesPlayed = serviceGamesPlayed;
    }

    public void setServiceGamesWonPct(BigDecimal serviceGamesWonPct) {
        this.serviceGamesWonPct = serviceGamesWonPct;
    }

    public void setServicePointsWonPct(BigDecimal servicePointsWonPct) {
        this.servicePointsWonPct = servicePointsWonPct;
    }

    public void setReturnFirstServeWonPct(BigDecimal returnFirstServeWonPct) {
        this.returnFirstServeWonPct = returnFirstServeWonPct;
    }

    public void setReturnSecondServeWonPct(BigDecimal returnSecondServeWonPct) {
        this.returnSecondServeWonPct = returnSecondServeWonPct;
    }

    public void setBreakPointOpportunities(int breakPointOpportunities) {
        this.breakPointOpportunities = breakPointOpportunities;
    }

    public void setBreakPointsConvertedPct(BigDecimal breakPointsConvertedPct) {
        this.breakPointsConvertedPct = breakPointsConvertedPct;
    }

    public void setReturnGamesPlayed(int returnGamesPlayed) {
        this.returnGamesPlayed = returnGamesPlayed;
    }

    public void setReturnGamesWonPct(BigDecimal returnGamesWonPct) {
        this.returnGamesWonPct = returnGamesWonPct;
    }

    public void setReturnPointsWonPct(BigDecimal returnPointsWonPct) {
        this.returnPointsWonPct = returnPointsWonPct;
    }

    public void setTotalPointsWonPct(BigDecimal totalPointsWonPct) {
        this.totalPointsWonPct = totalPointsWonPct;
    }

    public int getBreakPointsFaced() {
        return breakPointsFaced;
    }

    public BigDecimal getBreakPointsSavedPct() {
        return breakPointsSavedPct;
    }

    public int getServiceGamesPlayed() {
        return serviceGamesPlayed;
    }

    public BigDecimal getServiceGamesWonPct() {
        return serviceGamesWonPct;
    }

    public BigDecimal getServicePointsWonPct() {
        return servicePointsWonPct;
    }

    public BigDecimal getReturnFirstServeWonPct() {
        return returnFirstServeWonPct;
    }

    public BigDecimal getReturnSecondServeWonPct() {
        return returnSecondServeWonPct;
    }

    public int getBreakPointOpportunities() {
        return breakPointOpportunities;
    }

    public BigDecimal getBreakPointsConvertedPct() {
        return breakPointsConvertedPct;
    }

    public int getReturnGamesPlayed() {
        return returnGamesPlayed;
    }

    public BigDecimal getReturnGamesWonPct() {
        return returnGamesWonPct;
    }

    public BigDecimal getReturnPointsWonPct() {
        return returnPointsWonPct;
    }

    public BigDecimal getTotalPointsWonPct() {
        return totalPointsWonPct;
    }
}
