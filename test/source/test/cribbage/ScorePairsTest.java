package test.cribbage;

import cribbage.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ScorePairsTest {

    @Test
    void twoPointsForAPairsOfCardOfAKind() {
        CribbageHand cribbageHand = new CribbageHand(Arrays.asList(
                new Card(new Rank('2'), Suite.DIAMONDS),
                new Card(new Rank('A'), Suite.DIAMONDS),
                new Card(new Rank('2'), Suite.CLUBS),
                new Card(new Rank('7'), Suite.DIAMONDS)),
                new Card(new Rank('9'), Suite.DIAMONDS)
        );
        assertThat(new PairsRule().score(cribbageHand), is(2));
    }

    @Test
    void fourPointsForTwoPairsOfCardOfAKind() {
        CribbageHand cribbageHand = new CribbageHand(Arrays.asList(
                new Card(new Rank('3'), Suite.DIAMONDS),
                new Card(new Rank('A'), Suite.DIAMONDS),
                new Card(new Rank('3'), Suite.CLUBS),
                new Card(new Rank('6'), Suite.DIAMONDS)),
                new Card(new Rank('A'), Suite.HEARTS)
        );
        assertThat(new PairsRule().score(cribbageHand), is(4));
    }

    @Test
    void sixPointsForThreeCardsOfAKind() {
        CribbageHand cribbageHand = new CribbageHand(Arrays.asList(
                new Card(new Rank('3'), Suite.DIAMONDS),
                new Card(new Rank('A'), Suite.DIAMONDS),
                new Card(new Rank('3'), Suite.CLUBS),
                new Card(new Rank('6'), Suite.DIAMONDS)),
                new Card(new Rank('3'), Suite.HEARTS)
        );
        assertThat(new PairsRule().score(cribbageHand), is(6));
    }

    @Test
    void twelvePointsForFourCardsOfAKind() {
        CribbageHand cribbageHand = new CribbageHand(Arrays.asList(
                new Card(new Rank('A'), Suite.DIAMONDS),
                new Card(new Rank('A'), Suite.SPADES),
                new Card(new Rank('A'), Suite.CLUBS),
                new Card(new Rank('6'), Suite.DIAMONDS)),
                new Card(new Rank('A'), Suite.HEARTS)
        );
        assertThat(new PairsRule().score(cribbageHand), is(12));
    }
}
