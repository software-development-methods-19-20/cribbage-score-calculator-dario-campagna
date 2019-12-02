package cribbage;

public class PairsRule implements Rule {

    @Override
    public int score(CribbageHand cribbageHand) {
        return 2 * cribbageHand.numberOfPairs();
    }
}
