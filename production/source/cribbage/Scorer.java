package cribbage;

import java.util.stream.Stream;

public class Scorer {
    private Stream<Rule> rules;

    public Scorer(Stream<Rule> rules) {
        this.rules = rules;
    }

    public Integer score(CribbageHand cribbageHand) {
        return rules.mapToInt(r -> r.score(cribbageHand)).sum();
    }
}
