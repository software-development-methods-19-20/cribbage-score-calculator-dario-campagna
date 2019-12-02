package cribbage;

import java.util.ArrayList;
import java.util.List;

public class PairsRule implements Rule {
    public int applyTo(List<Card> handCards, Card starterCard) {
        List<Card> allCards = new ArrayList<>(handCards);
        allCards.add(starterCard);
        return (int) (2 * numberOfPairsIn(allCards));
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
}
