package test.cribbage;

import cribbage.Card;
import cribbage.CribbageHand;
import cribbage.FifteenTwoRule;
import cribbage.Suite;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ScoreFifteenTwosTest {

    @Test
    void fifteenTwo() {
        CribbageHand cribbageHand = new CribbageHand(
                Arrays.asList(
                        new Card('0', Suite.SPADES),
                        new Card('5', Suite.DIAMONDS),
                        new Card('3', Suite.SPADES),
                        new Card('A', Suite.HEARTS)
                ),
                new Card('8', Suite.CLUBS));
        assertThat(new FifteenTwoRule().score(cribbageHand), is(2));
    }

    @Test
    @Disabled
    void fifteenFour() {
        CribbageHand cribbageHand = new CribbageHand(
                Arrays.asList(
                        new Card('0', Suite.SPADES),
                        new Card('5', Suite.DIAMONDS),
                        new Card('3', Suite.SPADES),
                        new Card('A', Suite.HEARTS)
                ),
                new Card('7', Suite.CLUBS));
        assertThat(new FifteenTwoRule().score(cribbageHand), is(4));
    }
}
