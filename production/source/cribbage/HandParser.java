package cribbage;

import java.util.ArrayList;
import java.util.List;

public class HandParser {
    public static CribbageHand parse(String cardsAsText) {
        List<Card> cards = new ArrayList<>();
        while (!cardsAsText.isEmpty()) {
            String cardAsText = cardsAsText.substring(0, 2);
            cardsAsText = cardsAsText.substring(2);
            cards.add(CardParser.parseCard(cardAsText));
        }
        return new CribbageHand(cards);
    }
}
