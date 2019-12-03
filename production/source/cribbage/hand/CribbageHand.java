package cribbage.hand;

import org.paukov.combinatorics3.Generator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CribbageHand {
    private List<Card> handCards;
    private Card starterCard;

    public CribbageHand(List<Card> handCards, Card starterCard) {
        this.handCards = handCards;
        this.starterCard = starterCard;
    }

    public int numberOfPairs() {
        Stream<List<Card>> combinations = Generator.combination(allCards()).simple(2).stream();
        return (int) combinations.filter(comb -> comb.get(0).rank().equals(comb.get(1).rank())).count();
    }

    public boolean isFlush() {
        return handCards.stream().allMatch(card -> card.suite().equals(handCards.get(0).suite()));
    }

    public boolean isStarterCardSuiteSameAsHandCards() {
        return isFlush() && starterCard.suite().equals(handCards.get(0).suite());
    }

    public boolean hasHisNob() {
        return handCards.stream().anyMatch(card -> card.suite().equals(starterCard.suite()) && card.isJack());
    }

    public int numbersOfRunsOf(int n) {
        List<Rank> ranks = allCards().stream().map(Card::rank).collect(Collectors.toList());
        return (int) Generator.combination(ranks).simple(n).stream().filter(Rank::areConsecutive).count();
    }

    public int numberOfFifteenTwos() {
        return IntStream.rangeClosed(2, 5)
                .map(i -> (int)combinationsOfRankValues(i).filter(isSumFifteen()).count()).sum();
    }

    private Stream<List<Integer>> combinationsOfRankValues(int i) {
        List<Integer> ranksValues = allCards().stream().map(c -> c.rank().toInt()).collect(Collectors.toList());
        return Generator.combination(ranksValues).simple(i).stream();
    }

    private List<Card> allCards() {
        List<Card> cards = new ArrayList<>(handCards);
        cards.add(starterCard);
        return cards;
    }

    private Predicate<List<Integer>> isSumFifteen() {
        return comb -> comb.stream().reduce(0, Integer::sum) == 15;
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
