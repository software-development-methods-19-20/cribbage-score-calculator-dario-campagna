package cribbage;

import org.paukov.combinatorics3.Generator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CribbageHand {
    private List<Card> handCards;
    private Card starterCard;

    public CribbageHand(List<Card> handCards, Card starterCard) {
        this.handCards = handCards;
        this.starterCard = starterCard;
    }

    public int numberOfPairs() {
        return (int) numberOfPairsIn(allCards());
    }

    public boolean isFlush() {
        return handCards.stream().allMatch(card -> card.suite().equals(handCards.get(0).suite()));
    }

    public boolean isStarterCardSuiteSameAsHandCards() {
        return isFlush() && starterCard.suite().equals(handCards.get(0).suite());
    }

    public boolean hasHisNob() {
        return handCards.stream().anyMatch(card -> card.suite().equals(starterCard.suite()) && card.rank().isJack());
    }

    public int numberOfFifteenTwos() {
        return (int) (combinationsOfRankValues(2).filter(isSumFifteen()).count() +
                combinationsOfRankValues(3).filter(isSumFifteen()).count() +
                combinationsOfRankValues(4).filter(isSumFifteen()).count() +
                combinationsOfRankValues(5).filter(isSumFifteen()).count());
    }

    private Stream<List<Integer>> combinationsOfRankValues(int i) {
        return Generator.combination(allRanksValues()).simple(i).stream();
    }

    private Predicate<List<Integer>> isSumFifteen() {
        return comb -> comb.stream().reduce(0, (x, y) -> x + y) == 15;
    }

    private List<Integer> allRanksValues() {
        return allCards().stream().map(c -> c.rank().toInt()).collect(Collectors.toList());
    }

    private List<Card> allCards() {
        List<Card> cards = new ArrayList<>(handCards);
        cards.add(starterCard);
        return cards;
    }

    private long numberOfPairsIn(List<Card> cards) {
        Stream<List<Card>> combinations = Generator.combination(cards).simple(2).stream();
        return combinations.filter(comb -> comb.get(0).rank().equals(comb.get(1).rank())).count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CribbageHand that = (CribbageHand) o;

        if (!handCards.equals(that.handCards)) return false;
        return starterCard.equals(that.starterCard);
    }

    @Override
    public int hashCode() {
        int result = handCards.hashCode();
        result = 31 * result + starterCard.hashCode();
        return result;
    }
}
