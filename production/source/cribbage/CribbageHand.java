package cribbage;

import java.util.ArrayList;
import java.util.List;

public class CribbageHand {
    private List<Card> handCards;
    private Card starterCard;

    public CribbageHand(List<Card> handCards, Card starterCard) {
        this.handCards = handCards;
        this.starterCard = starterCard;
    }

    public int scoreWith(Rule rule) {
        return rule.applyTo(handCards, starterCard);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CribbageHand that = (CribbageHand) o;

        if (!handCards.equals(that.handCards)) return false;
        return starterCard.equals(that.starterCard);
    }

    @Override
    public int hashCode() {
        int result = handCards.hashCode();
        result = 31 * result + starterCard.hashCode();
        return result;
    }
}
