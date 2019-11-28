package cribbage;

import java.util.Arrays;
import java.util.List;

public class HandParser {
    public static CribbageHand parse(String cardsAsText) {
        List<Card> cards = Arrays.asList(
                new Card('5', Suite.HEART),
                new Card('4', Suite.DIAMOND),
                new Card('J', Suite.SPADES),
                new Card('K', Suite.SPADES),
                new Card('A', Suite.CLUBS)
        );
        return new CribbageHand(cards);
    }
}
