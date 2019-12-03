package test.cribbage;

import cribbage.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ScoreFifteenTwosTest {

    @Test
    void fifteenTwo() {
        CribbageHand cribbageHand = new CribbageHand(
                Arrays.asList(
                        new Card(new Rank('0'), Suite.SPADES),
                        new Card(new Rank('5'), Suite.DIAMONDS),
                        new Card(new Rank('3'), Suite.SPADES),
                        new Card(new Rank('A'), Suite.HEARTS)
                ),
                new Card(new Rank('8'), Suite.CLUBS));
        assertThat(new FifteenTwosRule().score(cribbageHand), is(2));
    }

    @Test
    void fifteenFour() {
        CribbageHand cribbageHand = new CribbageHand(
                Arrays.asList(
                        new Card(new Rank('0'), Suite.SPADES),
                        new Card(new Rank('5'), Suite.DIAMONDS),
                        new Card(new Rank('3'), Suite.SPADES),
                        new Card(new Rank('A'), Suite.HEARTS)
                ),
                new Card(new Rank('7'), Suite.CLUBS));
        assertThat(new FifteenTwosRule().score(cribbageHand), is(4));
    }

    @Test
    void fifteenFourWithFourCards() {
        CribbageHand cribbageHand = new CribbageHand(
                Arrays.asList(
                        new Card(new Rank('2'), Suite.SPADES),
                        new Card(new Rank('5'), Suite.DIAMONDS),
                        new Card(new Rank('3'), Suite.SPADES),
                        new Card(new Rank('A'), Suite.HEARTS)
                ),
                new Card(new Rank('5'), Suite.CLUBS));
        assertThat(new FifteenTwosRule().score(cribbageHand), is(2));
    }

    @Test
    void fifteenFourWithFiveCards() {
        CribbageHand cribbageHand = new CribbageHand(
                Arrays.asList(
                        new Card(new Rank('2'), Suite.SPADES),
                        new Card(new Rank('5'), Suite.DIAMONDS),
                        new Card(new Rank('3'), Suite.SPADES),
                        new Card(new Rank('3'), Suite.HEARTS)
                ),
                new Card(new Rank('2'), Suite.CLUBS));
        assertThat(new FifteenTwosRule().score(cribbageHand), is(2));
    }
}
