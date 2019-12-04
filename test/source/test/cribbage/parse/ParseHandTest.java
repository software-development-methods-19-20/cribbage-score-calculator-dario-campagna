package test.cribbage.parse;

import cribbage.hand.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ParseHandTest {

    @Test
    void parseHand() {
        CribbageHand expectedCribbageHand = new CribbageHand(Arrays.asList(
                new Card(Rank.create('5'), Suite.HEARTS),
                new Card(Rank.create('4'), Suite.DIAMONDS),
                new Card(Rank.create('J'), Suite.SPADES),
                new Card(Rank.create('K'), Suite.SPADES)),
                new Card(Rank.create('A'), Suite.CLUBS)
        );
        assertThat(HandParser.parse("5H4DJSKSAC"), is(expectedCribbageHand));
    }

    @Test
    void parseAnotherHand() {
        CribbageHand expectedCribbageHand = new CribbageHand(Arrays.asList(
                new Card(Rank.create('A'), Suite.HEARTS),
                new Card(Rank.create('0'), Suite.DIAMONDS),
                new Card(Rank.create('0'), Suite.CLUBS),
                new Card(Rank.create('K'), Suite.SPADES)),
                new Card(Rank.create('7'), Suite.HEARTS)
        );
        assertThat(HandParser.parse("AH0D0CKS7H"), is(expectedCribbageHand));
    }
}
