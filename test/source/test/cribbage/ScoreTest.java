package test.cribbage;

import cribbage.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ScoreTest {

    private Scorer scorer = new Scorer(Stream.of(new PairsRule(), new FlushRule()));

    @Test
    void pair() {
        CribbageHand cribbageHand = new CribbageHand(Arrays.asList(
                new Card(new Rank('2'), Suite.DIAMONDS),
                new Card(new Rank('A'), Suite.DIAMONDS),
                new Card(new Rank('2'), Suite.CLUBS),
                new Card(new Rank('7'), Suite.DIAMONDS)),
                new Card(new Rank('9'), Suite.DIAMONDS)
        );
        assertThat(scorer.score(cribbageHand), is(2));
    }

    @Test
    void twoPairs() {
        CribbageHand cribbageHand = new CribbageHand(Arrays.asList(
                new Card(new Rank('3'), Suite.DIAMONDS),
                new Card(new Rank('A'), Suite.DIAMONDS),
                new Card(new Rank('3'), Suite.CLUBS),
                new Card(new Rank('6'), Suite.DIAMONDS)),
                new Card(new Rank('A'), Suite.HEARTS)
        );
        assertThat(scorer.score(cribbageHand), is(4));
    }

    @Test
    void pairRoyal() {
        CribbageHand cribbageHand = new CribbageHand(Arrays.asList(
                new Card(new Rank('6'), Suite.HEARTS),
                new Card(new Rank('A'), Suite.DIAMONDS),
                new Card(new Rank('6'), Suite.CLUBS),
                new Card(new Rank('6'), Suite.DIAMONDS)),
                new Card(new Rank('0'), Suite.HEARTS)
        );
        assertThat(scorer.score(cribbageHand), is(6));
    }

    @Test
    void doublePairRoyal() {
        CribbageHand cribbageHand = new CribbageHand(Arrays.asList(
                new Card(new Rank('K'), Suite.HEARTS),
                new Card(new Rank('K'), Suite.SPADES),
                new Card(new Rank('K'), Suite.CLUBS),
                new Card(new Rank('K'), Suite.DIAMONDS)),
                new Card(new Rank('0'), Suite.HEARTS)
        );
        assertThat(scorer.score(cribbageHand), is(12));
    }

    @Test
    void flush() {
        CribbageHand cribbageHand = new CribbageHand(Arrays.asList(
                new Card(new Rank('4'), Suite.HEARTS),
                new Card(new Rank('9'), Suite.HEARTS),
                new Card(new Rank('3'), Suite.HEARTS),
                new Card(new Rank('K'), Suite.HEARTS)),
                new Card(new Rank('0'), Suite.SPADES)
        );
        assertThat(scorer.score(cribbageHand), is(4));
    }

    @Test
    void flushPlusAdditionalPoints() {
        CribbageHand cribbageHand = new CribbageHand(Arrays.asList(
                new Card(new Rank('4'), Suite.HEARTS),
                new Card(new Rank('J'), Suite.HEARTS),
                new Card(new Rank('3'), Suite.HEARTS),
                new Card(new Rank('K'), Suite.HEARTS)),
                new Card(new Rank('0'), Suite.HEARTS)
        );
        assertThat(scorer.score(cribbageHand), is(6));
    }
}
