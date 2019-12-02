package cribbage;

import java.util.List;

public class FlushRule implements Rule {

    @Override
    public int applyTo(List<Card> handCards, Card starterCard) {
        if (handCards.stream().allMatch(card -> card.suite().equals(handCards.get(0).suite()))) {
            return 4;
        } else {
            return 0;
        }
    }
}
