package test.cribbage;

import cribbage.Card;
import cribbage.CribbageHand;
import cribbage.Scorer;
import cribbage.Suite;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ScoreTest {

    @Test
    void twoPointsForAPairOfCardsOfAKind() {
        CribbageHand cribbageHand = new CribbageHand(Arrays.asList(
                new Card('2', Suite.DIAMONDS),
                new Card('A', Suite.DIAMONDS),
                new Card('2', Suite.CLUBS),
                new Card('7', Suite.DIAMONDS),
                new Card('9', Suite.DIAMONDS)
        ));
        assertThat(Scorer.score(cribbageHand), is(2));
    }

    @Test
    @Disabled
    void fourPointsForTwoPairsOfCardsOfAKind() {
        CribbageHand cribbageHand = new CribbageHand(Arrays.asList(
                new Card('3', Suite.DIAMONDS),
                new Card('A', Suite.DIAMONDS),
                new Card('3', Suite.CLUBS),
                new Card('6', Suite.DIAMONDS),
                new Card('A', Suite.HEARTS)
        ));
        assertThat(Scorer.score(cribbageHand), is(4));
    }
}
