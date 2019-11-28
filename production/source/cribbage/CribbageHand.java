package cribbage;

import java.util.List;

public class CribbageHand {
    private List<Card> cards;

    public CribbageHand(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CribbageHand that = (CribbageHand) o;

        return cards.equals(that.cards);
    }

    @Override
    public int hashCode() {
        return cards.hashCode();
    }
}
