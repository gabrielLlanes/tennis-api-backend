package com.example.tennisBackendCode.model;
import java.util.List;

public class DailyMatches {
    private java.sql.Date matchesDate;
    private boolean recorded;
    private List<DailyMatch> matches;

    public DailyMatches() {}

    public DailyMatches(java.sql.Date matchesDate, boolean recorded, List<DailyMatch> matches) {
        this.matchesDate=matchesDate; this.recorded = recorded; this.matches = matches;
    }

    public void setMatchesDate(java.sql.Date matchesDate) {
        this.matchesDate = matchesDate;
    }
    
    public java.sql.Date getMatchesDate() {
        return matchesDate;
    }

    public void setRecorded(boolean recorded) {
        this.recorded = recorded;
    }
    
    public boolean isRecorded() {
        return recorded;
    }

    public void setMatches(List<DailyMatch> matches) {
        this.matches = matches;
    }
    public List<DailyMatch> getMatches() {
        return matches;
    }
}
