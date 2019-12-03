package cribbage.rules;

import cribbage.hand.CribbageHand;

public interface Rule {

    int score(CribbageHand cribbageHand);

}
