package cribbage;

import java.util.HashMap;
import java.util.Map;

public class CardParser {

    private static Map<Character, Suite> charToSuite = new HashMap<>() {{
        put('C', Suite.CLUBS);
        put('H', Suite.HEART);
        put('D', Suite.DIAMOND);
        put('S', Suite.SPADES);
    }};

    public static Card parse(String cardAsText) {
        return new Card(parseRank(cardAsText), parseSuite(cardAsText));
    }

    private static char parseRank(String cardAsText) {
        return cardAsText.charAt(0);
    }

    private static Suite parseSuite(String cardAsText) {
        return charToSuite.get(cardAsText.charAt(1));
    }
}
