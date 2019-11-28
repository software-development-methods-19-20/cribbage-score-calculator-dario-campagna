package cribbage;

public class CardParser {
    public static Card parseCard(String cardAsText) {
        return new Card(parseRank(cardAsText), parseSuite(cardAsText));
    }

    private static char parseRank(String cardAsText) {
        return cardAsText.charAt(0);
    }

    private static Suite parseSuite(String cardAsText) {
        if (cardAsText.charAt(1) == 'H') {
            return Suite.HEART;
        } else if (cardAsText.charAt(1) == 'C') {
            return Suite.CLUBS;
        } else {
            return Suite.DIAMOND;
        }
    }
}
