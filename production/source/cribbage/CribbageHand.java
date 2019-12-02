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

    public int numberOfPairs() {
        return (int) numberOfPairsIn(allCards());
    }

    public boolean isFlush() {
        return handCards.stream().allMatch(card -> card.suite().equals(handCards.get(0).suite()));
    }

    public boolean isStarterCardSuiteSameAsHandCards() {
        return isFlush() && starterCard.suite().equals(handCards.get(0).suite());
    }

    public boolean hasHisNob() {
        return handCards.stream().anyMatch(card -> card.suite().equals(starterCard.suite()) && card.rank() == 'J');
    }

    private List<Card> allCards() {
        List<Card> cards = new ArrayList<>(handCards);
        cards.add(starterCard);
        return cards;
    }

    private long numberOfPairsIn(List<Card> cards) {
        if (cards.isEmpty()) {
            return 0;
        } else {
            Card card = cards.get(0);
            cards = cards.subList(1, cards.size());
            return cards.stream().filter(c -> c.rank() == card.rank()).count() + numberOfPairsIn(cards);
        }
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
