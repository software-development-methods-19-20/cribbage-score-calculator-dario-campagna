package cribbage;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class HandParser {

    public static CribbageHand parse(String cardsAsText) {
        return new CribbageHand(parseCards(cardsAsText));
    }

    private static List<Card> parseCards(String cardsAsText) {
        Matcher matcher = Pattern.compile("..").matcher(cardsAsText);
        return matcher.results().map(m -> CardParser.parse(m.group())).collect(Collectors.toList());
    }

}
