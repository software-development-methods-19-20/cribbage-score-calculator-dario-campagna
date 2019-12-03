package cribbage.rules;

import cribbage.hand.CribbageHand;

public class FifteenTwosRule implements Rule {
    @Override
    public int score(CribbageHand cribbageHand) {
        return 2 * cribbageHand.numberOfFifteenTwos();
    }
}
