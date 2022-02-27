package com.example.tennisBackendCode.miscTools.comparators;

import com.example.tennisBackendCode.model.PlayerActivitySingleTournamentMatch;

import java.util.Comparator;

public class SingleTournamentMatchComparator implements Comparator<PlayerActivitySingleTournamentMatch>{
    @Override
    public int compare(PlayerActivitySingleTournamentMatch a, PlayerActivitySingleTournamentMatch b) {
        return RoundComparator.getComparator().compare(a.getRound(), b.getRound());
    }

}
