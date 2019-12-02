package cribbage;

import java.util.List;

public class FlushRule implements Rule {

    @Override
    public int applyTo(List<Card> handCards, Card starterCard) {
        return pointsForHandCardsAllOfTheSameSuite(handCards) + pointsForStarterCardOfTheSameSuite(handCards, starterCard);
    }

    private int pointsForHandCardsAllOfTheSameSuite(List<Card> handCards) {
        return handCards.stream().allMatch(card -> card.suite().equals(handCards.get(0).suite())) ? 4 : 0;
    }

    private int pointsForStarterCardOfTheSameSuite(List<Card> handCards, Card starterCard) {
        return handCards.stream().allMatch(card -> card.suite().equals(starterCard.suite())) ? 1 : 0;
    }
}
