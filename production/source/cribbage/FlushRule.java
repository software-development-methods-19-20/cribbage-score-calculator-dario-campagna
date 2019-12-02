package cribbage;

import java.util.List;

public class FlushRule implements Rule {

    @Override
    public int applyTo(List<Card> handCards, Card starterCard) {
        return pointsForHandCardsAllOfTheSameSuite(handCards) +
                pointsForStarterCardOfTheSameSuite(handCards, starterCard) +
                oneForHisNob(handCards, starterCard);
    }

    private int pointsForHandCardsAllOfTheSameSuite(List<Card> handCards) {
        return handCards.stream().allMatch(card -> card.suite().equals(handCards.get(0).suite())) ? 4 : 0;
    }

    private int pointsForStarterCardOfTheSameSuite(List<Card> handCards, Card starterCard) {
        return handCards.stream().allMatch(card -> card.suite().equals(starterCard.suite())) ? 1 : 0;
    }

    private int oneForHisNob(List<Card> handCards, Card starterCard) {
        return handCards.stream().anyMatch(card -> isHisNob(card, starterCard)) ? 1 : 0;
    }

    private boolean isHisNob(Card card, Card starterCard) {
        return card.suite().equals(starterCard.suite()) && card.rank() == 'J';
    }
}
