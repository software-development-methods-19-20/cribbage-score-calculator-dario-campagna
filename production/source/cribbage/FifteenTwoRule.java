package cribbage;

public class FifteenTwoRule implements Rule {
    @Override
    public int score(CribbageHand cribbageHand) {
        return 2 * cribbageHand.numberOfFifteenTwos();
    }
}
