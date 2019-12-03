package cribbage.rules;

import cribbage.hand.CribbageHand;

public class RunsRule implements Rule {
    @Override
    public int score(CribbageHand cribbageHand) {
        if (cribbageHand.isRunOfFive()) {
            return 5;
        } else if (cribbageHand.isRunOfFour()) {
            return 4;
        } else {
            return 0;
        }
    }
}
