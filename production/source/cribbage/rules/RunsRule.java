package cribbage.rules;

import cribbage.hand.CribbageHand;

public class RunsRule implements Rule {
    @Override
    public int score(CribbageHand cribbageHand) {
        if (isRunOf(5, cribbageHand)) {
            return 5;
        } else if (isRunOf(4, cribbageHand)) {
            return 4;
        } else {
            return 3 * cribbageHand.numbersOfRunsOf(3);
        }
    }

    private boolean isRunOf(int i, CribbageHand cribbageHand) {
        return cribbageHand.numbersOfRunsOf(i) > 0;
    }
}
