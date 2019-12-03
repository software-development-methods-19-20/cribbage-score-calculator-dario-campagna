package cribbage.hand;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rank implements Comparable<Rank> {
    private static final Map<Character, Integer> VALUE_BY_CHARACTER = new HashMap<>() {{
        put('A', 1);
        put('2', 2);
        put('3', 3);
        put('4', 4);
        put('5', 5);
        put('6', 6);
        put('7', 7);
        put('8', 8);
        put('9', 9);
        put('0', 10);
        put('J', 10);
        put('Q', 10);
        put('K', 10);
    }};
    private static final Map<Character, Integer> ORDINAL_BY_CHARACTER = new HashMap<>() {{
        put('A', 1);
        put('2', 2);
        put('3', 3);
        put('4', 4);
        put('5', 5);
        put('6', 6);
        put('7', 7);
        put('8', 8);
        put('9', 9);
        put('0', 10);
        put('J', 11);
        put('Q', 12);
        put('K', 13);
    }};
    private char rankAsChar;

    public static boolean areConsecutive(List<Rank> ranks) {
        Collections.sort(ranks);
        boolean areConsecutive = true;
        int i = 1;
        while (i < ranks.size() && areConsecutive) {
            if (ranks.get(i).notSuccessorOf(ranks.get(i - 1))) {
                areConsecutive = false;
            }
            i++;
        }
        return areConsecutive;
    }

    public Rank(char rankAsChar) {
        this.rankAsChar = rankAsChar;
    }

    public int toInt() {
        return VALUE_BY_CHARACTER.get(rankAsChar);
    }

    public boolean isJack() {
        return rankAsChar == 'J';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rank rank = (Rank) o;

        return rankAsChar == rank.rankAsChar;
    }

    @Override
    public int hashCode() {
        return rankAsChar;
    }

    @Override
    public int compareTo(Rank other) {
        return ORDINAL_BY_CHARACTER.get(rankAsChar) - ORDINAL_BY_CHARACTER.get(other.rankAsChar);
    }

    private boolean notSuccessorOf(Rank rank) {
        return ORDINAL_BY_CHARACTER.get(rankAsChar) - ORDINAL_BY_CHARACTER.get(rank.rankAsChar) != 1;
    }
}
