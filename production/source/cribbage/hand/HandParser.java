package cribbage.hand;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class HandParser {

    public static CribbageHand parse(String cardsAsText) {
        List<Card> allCards = parseCards(cardsAsText);
        return new CribbageHand(allCards.subList(0, 4), allCards.get(4));
    }

    private static List<Card> parseCards(String cardsAsText) {
        Matcher matcher = Pattern.compile("..").matcher(cardsAsText);
        return matcher.results().map(m -> CardParser.parse(m.group())).collect(Collectors.toList());
    }

}
