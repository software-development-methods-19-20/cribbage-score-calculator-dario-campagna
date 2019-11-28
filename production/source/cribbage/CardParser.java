package cribbage;

public class CardParser {
    public static Card parseCard(String cardAsText) {
        if (cardAsText.charAt(1) == 'H'){
            return new Card(cardAsText.charAt(0), Suite.HEART);
        } else {
            return new Card(cardAsText.charAt(0), Suite.DIAMOND);
        }
    }
}
