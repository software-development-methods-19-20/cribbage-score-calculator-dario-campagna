package test.cribbage.score;

import cribbage.Scorer;
import cribbage.ScorerFactory;
import cribbage.hand.Card;
import cribbage.hand.CribbageHand;
import cribbage.hand.Rank;
import cribbage.hand.Suite;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ScoreTest {

    private Scorer scorer = ScorerFactory.create();

    @Test
    void pair() {
        CribbageHand cribbageHand = new CribbageHand(Arrays.asList(
                new Card(Rank.create('2'), Suite.DIAMONDS),
                new Card(Rank.create('A'), Suite.DIAMONDS),
                new Card(Rank.create('2'), Suite.CLUBS),
                new Card(Rank.create('7'), Suite.DIAMONDS)),
                new Card(Rank.create('9'), Suite.DIAMONDS)
        );
        assertThat(scorer.score(cribbageHand), is(2));
    }

    @Test
    void twoPairs() {
        CribbageHand cribbageHand = new CribbageHand(Arrays.asList(
                new Card(Rank.create('3'), Suite.DIAMONDS),
                new Card(Rank.create('A'), Suite.DIAMONDS),
                new Card(Rank.create('3'), Suite.CLUBS),
                new Card(Rank.create('6'), Suite.DIAMONDS)),
                new Card(Rank.create('A'), Suite.HEARTS)
        );
        assertThat(scorer.score(cribbageHand), is(4));
    }

    @Test
    void pairRoyal() {
        CribbageHand cribbageHand = new CribbageHand(Arrays.asList(
                new Card(Rank.create('6'), Suite.HEARTS),
                new Card(Rank.create('A'), Suite.DIAMONDS),
                new Card(Rank.create('6'), Suite.CLUBS),
                new Card(Rank.create('6'), Suite.DIAMONDS)),
                new Card(Rank.create('0'), Suite.HEARTS)
        );
        assertThat(scorer.score(cribbageHand), is(6));
    }

    @Test
    void doublePairRoyal() {
        CribbageHand cribbageHand = new CribbageHand(Arrays.asList(
                new Card(Rank.create('K'), Suite.HEARTS),
                new Card(Rank.create('K'), Suite.SPADES),
                new Card(Rank.create('K'), Suite.CLUBS),
                new Card(Rank.create('K'), Suite.DIAMONDS)),
                new Card(Rank.create('0'), Suite.HEARTS)
        );
        assertThat(scorer.score(cribbageHand), is(12));
    }

    @Test
    void flush() {
        CribbageHand cribbageHand = new CribbageHand(Arrays.asList(
                new Card(Rank.create('4'), Suite.HEARTS),
                new Card(Rank.create('9'), Suite.HEARTS),
                new Card(Rank.create('3'), Suite.HEARTS),
                new Card(Rank.create('K'), Suite.HEARTS)),
                new Card(Rank.create('0'), Suite.SPADES)
        );
        assertThat(scorer.score(cribbageHand), is(4));
    }

    @Test
    void flushPlusAdditionalPoints() {
        CribbageHand cribbageHand = new CribbageHand(Arrays.asList(
                new Card(Rank.create('4'), Suite.HEARTS),
                new Card(Rank.create('J'), Suite.HEARTS),
                new Card(Rank.create('3'), Suite.HEARTS),
                new Card(Rank.create('K'), Suite.HEARTS)),
                new Card(Rank.create('0'), Suite.HEARTS)
        );
        assertThat(scorer.score(cribbageHand), is(6));
    }

    @Test
    void fifteenSixteenAndSixPairs() {
        CribbageHand cribbageHand = new CribbageHand(Arrays.asList(
                new Card(Rank.create('5'), Suite.DIAMONDS),
                new Card(Rank.create('5'), Suite.HEARTS),
                new Card(Rank.create('5'), Suite.CLUBS),
                new Card(Rank.create('0'), Suite.SPADES)),
                new Card(Rank.create('5'), Suite.SPADES)
        );
        assertThat(scorer.score(cribbageHand), is(28));
    }

    @Test
    void eightPointsForADoubleRun() {
        CribbageHand cribbageHand = new CribbageHand(Arrays.asList(
                new Card(Rank.create('5'), Suite.DIAMONDS),
                new Card(Rank.create('5'), Suite.HEARTS),
                new Card(Rank.create('6'), Suite.CLUBS),
                new Card(Rank.create('A'), Suite.SPADES)),
                new Card(Rank.create('7'), Suite.SPADES)
        );
        assertThat(scorer.score(cribbageHand), is(8));
    }

    @Test
    void fifteenPointsForATripleRun() {
        CribbageHand cribbageHand = new CribbageHand(Arrays.asList(
                new Card(Rank.create('2'), Suite.DIAMONDS),
                new Card(Rank.create('2'), Suite.HEARTS),
                new Card(Rank.create('3'), Suite.CLUBS),
                new Card(Rank.create('4'), Suite.SPADES)),
                new Card(Rank.create('2'), Suite.SPADES)
        );
        assertThat(scorer.score(cribbageHand), is(15));
    }

    @Test
    void sixteenPointsForADoubleDoubleRun() {
        CribbageHand cribbageHand = new CribbageHand(Arrays.asList(
                new Card(Rank.create('4'), Suite.DIAMONDS),
                new Card(Rank.create('2'), Suite.HEARTS),
                new Card(Rank.create('3'), Suite.CLUBS),
                new Card(Rank.create('4'), Suite.SPADES)),
                new Card(Rank.create('3'), Suite.SPADES)
        );
        assertThat(scorer.score(cribbageHand), is(16));
    }

    @Test
    void highestPossibleScore() {
        CribbageHand cribbageHand = new CribbageHand(Arrays.asList(
                new Card(Rank.create('5'), Suite.DIAMONDS),
                new Card(Rank.create('5'), Suite.HEARTS),
                new Card(Rank.create('5'), Suite.CLUBS),
                new Card(Rank.create('J'), Suite.SPADES)),
                new Card(Rank.create('5'), Suite.SPADES)
        );
        assertThat(scorer.score(cribbageHand), is(29));
    }
}
