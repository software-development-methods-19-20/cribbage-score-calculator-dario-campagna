package cribbage;

import java.util.HashMap;
import java.util.Map;

public class Rank {
    private static final Map<Character, Integer> VALUE_BY_CHARACTER = new HashMap<>() {{
        put('A', 1);
        put('0', 10);
        put('J', 10);
        put('Q', 10);
        put('K', 10);
    }};
    private char rankAsChar;

    public Rank(char rankAsChar) {
        this.rankAsChar = rankAsChar;
    }

    public int toInt() {
        if (VALUE_BY_CHARACTER.containsKey(rankAsChar)) {
            return VALUE_BY_CHARACTER.get(rankAsChar);
        } else {
            return Integer.valueOf("" + rankAsChar);
        }
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
}
