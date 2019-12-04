package test.cribbage.score;

import cribbage.hand.Card;
import cribbage.hand.CribbageHand;
import cribbage.hand.Rank;
import cribbage.hand.Suite;
import cribbage.rules.PairsRule;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ScorePairsTest {

    @Test
    void twoPointsForAPairsOfCardOfAKind() {
        CribbageHand cribbageHand = new CribbageHand(Arrays.asList(
                new Card(Rank.create('2'), Suite.DIAMONDS),
                new Card(Rank.create('A'), Suite.DIAMONDS),
                new Card(Rank.create('2'), Suite.CLUBS),
                new Card(Rank.create('7'), Suite.DIAMONDS)),
                new Card(Rank.create('9'), Suite.DIAMONDS)
        );
        assertThat(new PairsRule().score(cribbageHand), is(2));
    }

    @Test
    void fourPointsForTwoPairsOfCardOfAKind() {
        CribbageHand cribbageHand = new CribbageHand(Arrays.asList(
                new Card(Rank.create('3'), Suite.DIAMONDS),
                new Card(Rank.create('A'), Suite.DIAMONDS),
                new Card(Rank.create('3'), Suite.CLUBS),
                new Card(Rank.create('6'), Suite.DIAMONDS)),
                new Card(Rank.create('A'), Suite.HEARTS)
        );
        assertThat(new PairsRule().score(cribbageHand), is(4));
    }

    @Test
    void sixPointsForThreeCardsOfAKind() {
        CribbageHand cribbageHand = new CribbageHand(Arrays.asList(
                new Card(Rank.create('3'), Suite.DIAMONDS),
                new Card(Rank.create('A'), Suite.DIAMONDS),
                new Card(Rank.create('3'), Suite.CLUBS),
                new Card(Rank.create('6'), Suite.DIAMONDS)),
                new Card(Rank.create('3'), Suite.HEARTS)
        );
        assertThat(new PairsRule().score(cribbageHand), is(6));
    }

    @Test
    void twelvePointsForFourCardsOfAKind() {
        CribbageHand cribbageHand = new CribbageHand(Arrays.asList(
                new Card(Rank.create('A'), Suite.DIAMONDS),
                new Card(Rank.create('A'), Suite.SPADES),
                new Card(Rank.create('A'), Suite.CLUBS),
                new Card(Rank.create('6'), Suite.DIAMONDS)),
                new Card(Rank.create('A'), Suite.HEARTS)
        );
        assertThat(new PairsRule().score(cribbageHand), is(12));
    }
}
