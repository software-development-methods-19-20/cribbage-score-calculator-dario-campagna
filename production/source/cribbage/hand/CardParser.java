package cribbage.hand;

import cribbage.hand.Card;
import cribbage.hand.Rank;
import cribbage.hand.Suite;

import java.util.HashMap;
import java.util.Map;

public class CardParser {

    private static Map<Character, Suite> charToSuite = new HashMap<>() {{
        put('C', Suite.CLUBS);
        put('H', Suite.HEARTS);
        put('D', Suite.DIAMONDS);
        put('S', Suite.SPADES);
    }};

    public static Card parse(String cardAsText) {
        return new Card(parseRank(cardAsText), parseSuite(cardAsText));
    }

    private static Rank parseRank(String cardAsText) {
        return new Rank(cardAsText.charAt(0));
    }

    private static Suite parseSuite(String cardAsText) {
        return charToSuite.get(cardAsText.charAt(1));
    }
}