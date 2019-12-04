package cribbage.hand;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Rank {

    private static final Map<Character, Rank> RANK_BY_CHARACTER = new HashMap<>() {{
        put('A', new Rank('A', 1, 1));
        put('2', new Rank('2', 2, 2));
        put('3', new Rank('3', 3, 3));
        put('4', new Rank('4', 4, 4));
        put('5', new Rank('5', 5, 5));
        put('6', new Rank('6', 6, 6));
        put('7', new Rank('7', 7, 7));
        put('8', new Rank('8', 8, 8));
        put('9', new Rank('9', 9, 9));
        put('0', new Rank('0', 10, 10));
        put('J', new Rank('J', 10, 11));
        put('Q', new Rank('Q', 10, 12));
        put('K', new Rank('K', 10, 13));
    }};

    private final char rankAsChar;
    private final int value;
    private final int ordinal;

    public static Rank create(char rankAsChar) {
        return RANK_BY_CHARACTER.get(rankAsChar);
    }

    public static boolean areConsecutive(List<Rank> ranks) {
        List<Integer> ordinals = ranks.stream().map(rank -> rank.ordinal)
                .sorted(Integer::compareTo).collect(Collectors.toList());
        List<Integer> consecutive = IntStream.rangeClosed(ordinals.get(0), ordinals.get(0) + ordinals.size() - 1)
                .boxed().collect(Collectors.toList());
        return consecutive.equals(ordinals);
    }

    private Rank(char rankAsChar, int value, int ordinal) {
        this.rankAsChar = rankAsChar;
        this.value = value;
        this.ordinal = ordinal;
    }

    public int toInt() {
        return value;
    }

    public boolean isJack() {
        return rankAsChar == 'J';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rank rank = (Rank) o;

        if (rankAsChar != rank.rankAsChar) return false;
        if (value != rank.value) return false;
        return ordinal == rank.ordinal;
    }

    @Override
    public int hashCode() {
        int result = rankAsChar;
        result = 31 * result + value;
        result = 31 * result + ordinal;
        return result;
    }
}
