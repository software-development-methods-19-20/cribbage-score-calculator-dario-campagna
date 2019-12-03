package cribbage;

import java.util.stream.Stream;

public class ScorerFactory {

    public static Scorer create() {
        return new Scorer(Stream.of(new PairsRule(), new FlushRule(), new FifteenTwosRule()));
    }
}
