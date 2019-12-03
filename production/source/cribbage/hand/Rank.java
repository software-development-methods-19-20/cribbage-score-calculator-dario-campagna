package cribbage.hand;

import java.util.*;

public class Rank implements Comparable {
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
    private static final Map<Character, Integer> ORDINAL_BY_CHARACTER = new HashMap<>(){{
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
    public int compareTo(Object o) {
        Rank other = (Rank) o;
        return ORDINAL_BY_CHARACTER.get(rankAsChar) - ORDINAL_BY_CHARACTER.get(other.rankAsChar);
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

    public Rank next() {
        if (rankAsChar == 'K') {
            return this;
        } else {
            return ORDINAL_BY_CHARACTER.entrySet().stream().filter(e -> e.getValue().equals(ORDINAL_BY_CHARACTER.get(rankAsChar)+1)).findFirst().map(e -> new Rank(e.getKey())).orElse(this);
        }
    }
}
