package test.cribbage;

import cribbage.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ParseHandTest {

    @Test
    void parseHand() {
        CribbageHand expectedCribbageHand = new CribbageHand(Arrays.asList(
                new Card(new Rank('5'), Suite.HEARTS),
                new Card(new Rank('4'), Suite.DIAMONDS),
                new Card(new Rank('J'), Suite.SPADES),
                new Card(new Rank('K'), Suite.SPADES)),
                new Card(new Rank('A'), Suite.CLUBS)
        );
        assertThat(HandParser.parse("5H4DJSKSAC"), is(expectedCribbageHand));
    }

    @Test
    void parseAnotherHand() {
        CribbageHand expectedCribbageHand = new CribbageHand(Arrays.asList(
                new Card(new Rank('A'), Suite.HEARTS),
                new Card(new Rank('0'), Suite.DIAMONDS),
                new Card(new Rank('0'), Suite.CLUBS),
                new Card(new Rank('K'), Suite.SPADES)),
                new Card(new Rank('7'), Suite.HEARTS)
        );
        assertThat(HandParser.parse("AH0D0CKS7H"), is(expectedCribbageHand));
    }
}
