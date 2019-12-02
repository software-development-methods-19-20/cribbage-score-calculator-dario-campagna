package test.cribbage;

import cribbage.Card;
import cribbage.CribbageHand;
import cribbage.FlushRule;
import cribbage.Suite;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ScoreFlushTest {

    @Test
    void fourPointsForAFlush() {
        CribbageHand cribbageHand = new CribbageHand(Arrays.asList(
                new Card('4', Suite.HEARTS),
                new Card('9', Suite.HEARTS),
                new Card('3', Suite.HEARTS),
                new Card('K', Suite.HEARTS)),
                new Card('0', Suite.SPADES)
        );
        assertThat(cribbageHand.scoreWith(new FlushRule()), is(4));
    }

    @Test
    void fivePointsForAFlushAndStarterCardOfTheSameSuite() {
        CribbageHand cribbageHand = new CribbageHand(Arrays.asList(
                new Card('4', Suite.HEARTS),
                new Card('9', Suite.HEARTS),
                new Card('3', Suite.HEARTS),
                new Card('K', Suite.HEARTS)),
                new Card('0', Suite.HEARTS)
        );
        assertThat(cribbageHand.scoreWith(new FlushRule()), is(5));
    }

    @Test
    void noFlushNoPoints() {
        CribbageHand cribbageHand = new CribbageHand(Arrays.asList(
                new Card('4', Suite.DIAMONDS),
                new Card('9', Suite.HEARTS),
                new Card('3', Suite.HEARTS),
                new Card('K', Suite.HEARTS)),
                new Card('0', Suite.SPADES)
        );
        assertThat(cribbageHand.scoreWith(new FlushRule()), is(0));
    }
}
