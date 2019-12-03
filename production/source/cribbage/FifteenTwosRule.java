package cribbage;

public class FifteenTwosRule implements Rule {
    @Override
    public int score(CribbageHand cribbageHand) {
        return 2 * cribbageHand.numberOfFifteenTwos();
    }
}
