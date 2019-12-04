package cribbage.hand;

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
        return Rank.create(cardAsText.charAt(0));
    }

    private static Suite parseSuite(String cardAsText) {
        return charToSuite.get(cardAsText.charAt(1));
    }
}
