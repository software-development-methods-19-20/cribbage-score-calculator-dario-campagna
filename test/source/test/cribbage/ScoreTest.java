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
                new Card('2', Suite.DIAMONDS),
                new Card('A', Suite.DIAMONDS),
                new Card('2', Suite.CLUBS),
                new Card('7', Suite.DIAMONDS)),
                new Card('9', Suite.DIAMONDS)
        );
        assertThat(scorer.score(cribbageHand), is(2));
    }

    @Test
    void twoPairs() {
        CribbageHand cribbageHand = new CribbageHand(Arrays.asList(
                new Card('3', Suite.DIAMONDS),
                new Card('A', Suite.DIAMONDS),
                new Card('3', Suite.CLUBS),
                new Card('6', Suite.DIAMONDS)),
                new Card('A', Suite.HEARTS)
        );
        assertThat(scorer.score(cribbageHand), is(4));
    }

    @Test
    void pairRoyal() {
        CribbageHand cribbageHand = new CribbageHand(Arrays.asList(
                new Card('6', Suite.HEARTS),
                new Card('A', Suite.DIAMONDS),
                new Card('6', Suite.CLUBS),
                new Card('6', Suite.DIAMONDS)),
                new Card('0', Suite.HEARTS)
        );
        assertThat(scorer.score(cribbageHand), is(6));
    }

    @Test
    void doublePairRoyal() {
        CribbageHand cribbageHand = new CribbageHand(Arrays.asList(
                new Card('K', Suite.HEARTS),
                new Card('K', Suite.SPADES),
                new Card('K', Suite.CLUBS),
                new Card('K', Suite.DIAMONDS)),
                new Card('0', Suite.HEARTS)
        );
        assertThat(scorer.score(cribbageHand), is(12));
    }

    @Test
    void flush() {
        CribbageHand cribbageHand = new CribbageHand(Arrays.asList(
                new Card('4', Suite.HEARTS),
                new Card('9', Suite.HEARTS),
                new Card('3', Suite.HEARTS),
                new Card('K', Suite.HEARTS)),
                new Card('0', Suite.SPADES)
        );
        assertThat(scorer.score(cribbageHand), is(4));
    }

    @Test
    void flushPlusAdditionalPoints() {
        CribbageHand cribbageHand = new CribbageHand(Arrays.asList(
                new Card('4', Suite.HEARTS),
                new Card('J', Suite.HEARTS),
                new Card('3', Suite.HEARTS),
                new Card('K', Suite.HEARTS)),
                new Card('0', Suite.HEARTS)
        );
        assertThat(scorer.score(cribbageHand), is(6));
    }
}
