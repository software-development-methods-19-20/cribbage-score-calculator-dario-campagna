package test.cribbage;

import cribbage.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ScoreFlushTest {

    @Test
    void fourPointsForAFlush() {
        CribbageHand cribbageHand = new CribbageHand(Arrays.asList(
                new Card(new Rank('4'), Suite.HEARTS),
                new Card(new Rank('9'), Suite.HEARTS),
                new Card(new Rank('3'), Suite.HEARTS),
                new Card(new Rank('K'), Suite.HEARTS)),
                new Card(new Rank('0'), Suite.SPADES)
        );
        assertThat(new FlushRule().score(cribbageHand), is(4));
    }

    @Test
    void fivePointsForAFlushAndStarterCardOfTheSameSuite() {
        CribbageHand cribbageHand = new CribbageHand(Arrays.asList(
                new Card(new Rank('4'), Suite.HEARTS),
                new Card(new Rank('9'), Suite.HEARTS),
                new Card(new Rank('3'), Suite.HEARTS),
                new Card(new Rank('K'), Suite.HEARTS)),
                new Card(new Rank('0'), Suite.HEARTS)
        );
        assertThat(new FlushRule().score(cribbageHand), is(5));
    }

    @Test
    void noFlushNoPoints() {
        CribbageHand cribbageHand = new CribbageHand(Arrays.asList(
                new Card(new Rank('4'), Suite.DIAMONDS),
                new Card(new Rank('9'), Suite.HEARTS),
                new Card(new Rank('3'), Suite.HEARTS),
                new Card(new Rank('K'), Suite.HEARTS)),
                new Card(new Rank('0'), Suite.SPADES)
        );
        assertThat(new FlushRule().score(cribbageHand), is(0));
    }

    @Test
    void onePointForHoldingTheJackOfTheSameSuiteAsTheStarterCard() {
        CribbageHand cribbageHand = new CribbageHand(Arrays.asList(
                new Card(new Rank('4'), Suite.DIAMONDS),
                new Card(new Rank('J'), Suite.SPADES),
                new Card(new Rank('3'), Suite.HEARTS),
                new Card(new Rank('K'), Suite.HEARTS)),
                new Card(new Rank('0'), Suite.SPADES)
        );
        assertThat(new FlushRule().score(cribbageHand), is(1));
    }
}
