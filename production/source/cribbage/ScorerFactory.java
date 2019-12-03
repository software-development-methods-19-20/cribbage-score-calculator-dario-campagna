package cribbage;

import cribbage.rules.FifteenTwosRule;
import cribbage.rules.FlushRule;
import cribbage.rules.PairsRule;
import cribbage.rules.RunsRule;

import java.util.stream.Stream;

public class ScorerFactory {

    public static Scorer create() {
        return new Scorer(Stream.of(new PairsRule(), new FlushRule(), new FifteenTwosRule(), new RunsRule()));
    }
}
