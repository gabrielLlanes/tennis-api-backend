package com.example.tennisBackendCode.miscTools.comparators;

import java.util.Comparator;

//Rounds are strings, yet they have a different order. For example, QF (Quarterfinal) > SF (Semifinal) > F (Final)
//if we want the latest round to go first in the list of matches for each player tournament appearance.
public class RoundComparator {

    public static Comparator<String> getComparator() {
        Comparator<String> c = Comparator.comparing(s -> {
            if(s.equals("F")) return 0;
            else if(s.equals("SF")) return 1;
            else if(s.equals("QF")) return 2;
            else if(s.equals("R16")) return 3;
            else if(s.equals("R32")) return 4;
            else if(s.equals("R64")) return 5;
            else if(s.equals("R128")) return 6;
            else if(s.equals("RR")) return 7;
            else return 8;
        });

        return c;
    }
}
