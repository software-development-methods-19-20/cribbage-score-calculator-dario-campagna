package test.cribbage;

import cribbage.Card;
import cribbage.CribbageHand;
import cribbage.PairsRule;
import cribbage.Suite;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ScorePairsTest {

    @Test
    void twoPointsForAPairsOfCardOfAKind() {
        CribbageHand cribbageHand = new CribbageHand(Arrays.asList(
                new Card('2', Suite.DIAMONDS),
                new Card('A', Suite.DIAMONDS),
                new Card('2', Suite.CLUBS),
                new Card('7', Suite.DIAMONDS),
                new Card('9', Suite.DIAMONDS)
        ));
        assertThat(cribbageHand.scoreWith(new PairsRule()), is(2));
    }

    @Test
    void fourPointsForTwoPairsOfCardOfAKind() {
        CribbageHand cribbageHand = new CribbageHand(Arrays.asList(
                new Card('3', Suite.DIAMONDS),
                new Card('A', Suite.DIAMONDS),
                new Card('3', Suite.CLUBS),
                new Card('6', Suite.DIAMONDS),
                new Card('A', Suite.HEARTS)
        ));
        assertThat(cribbageHand.scoreWith(new PairsRule()), is(4));
    }

    @Test
    void sixPointsForThreeCardsOfAKind() {
        CribbageHand cribbageHand = new CribbageHand(Arrays.asList(
                new Card('3', Suite.DIAMONDS),
                new Card('A', Suite.DIAMONDS),
                new Card('3', Suite.CLUBS),
                new Card('6', Suite.DIAMONDS),
                new Card('3', Suite.HEARTS)
        ));
        assertThat(cribbageHand.scoreWith(new PairsRule()), is(6));
    }

    @Test
    void twelvePointsForFourCardsOfAKind() {
        CribbageHand cribbageHand = new CribbageHand(Arrays.asList(
                new Card('A', Suite.DIAMONDS),
                new Card('A', Suite.SPADES),
                new Card('A', Suite.CLUBS),
                new Card('6', Suite.DIAMONDS),
                new Card('A', Suite.HEARTS)
        ));
        assertThat(cribbageHand.scoreWith(new PairsRule()), is(12));
    }
}
