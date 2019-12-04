package test.cribbage.score;

import cribbage.hand.Card;
import cribbage.hand.CribbageHand;
import cribbage.hand.Rank;
import cribbage.hand.Suite;
import cribbage.rules.FifteenTwosRule;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ScoreFifteenTwosTest {

    @Test
    void fifteenTwo() {
        CribbageHand cribbageHand = new CribbageHand(
                Arrays.asList(
                        new Card(Rank.create('0'), Suite.SPADES),
                        new Card(Rank.create('5'), Suite.DIAMONDS),
                        new Card(Rank.create('3'), Suite.SPADES),
                        new Card(Rank.create('A'), Suite.HEARTS)
                ),
                new Card(Rank.create('8'), Suite.CLUBS));
        assertThat(new FifteenTwosRule().score(cribbageHand), is(2));
    }

    @Test
    void fifteenFour() {
        CribbageHand cribbageHand = new CribbageHand(
                Arrays.asList(
                        new Card(Rank.create('0'), Suite.SPADES),
                        new Card(Rank.create('5'), Suite.DIAMONDS),
                        new Card(Rank.create('3'), Suite.SPADES),
                        new Card(Rank.create('A'), Suite.HEARTS)
                ),
                new Card(Rank.create('7'), Suite.CLUBS));
        assertThat(new FifteenTwosRule().score(cribbageHand), is(4));
    }

    @Test
    void fifteenFourWithFourCards() {
        CribbageHand cribbageHand = new CribbageHand(
                Arrays.asList(
                        new Card(Rank.create('2'), Suite.SPADES),
                        new Card(Rank.create('5'), Suite.DIAMONDS),
                        new Card(Rank.create('3'), Suite.SPADES),
                        new Card(Rank.create('A'), Suite.HEARTS)
                ),
                new Card(Rank.create('5'), Suite.CLUBS));
        assertThat(new FifteenTwosRule().score(cribbageHand), is(2));
    }

    @Test
    void fifteenFourWithFiveCards() {
        CribbageHand cribbageHand = new CribbageHand(
                Arrays.asList(
                        new Card(Rank.create('2'), Suite.SPADES),
                        new Card(Rank.create('5'), Suite.DIAMONDS),
                        new Card(Rank.create('3'), Suite.SPADES),
                        new Card(Rank.create('3'), Suite.HEARTS)
                ),
                new Card(Rank.create('2'), Suite.CLUBS));
        assertThat(new FifteenTwosRule().score(cribbageHand), is(2));
    }
}
