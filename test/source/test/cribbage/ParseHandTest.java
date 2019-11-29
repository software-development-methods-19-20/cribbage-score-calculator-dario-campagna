package test.cribbage;

import cribbage.Card;
import cribbage.CribbageHand;
import cribbage.HandParser;
import cribbage.Suite;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ParseHandTest {

    @Test
    void parseHand() {
        CribbageHand expectedCribbageHand = new CribbageHand(Arrays.asList(
                new Card('5', Suite.HEARTS),
                new Card('4', Suite.DIAMONDS),
                new Card('J', Suite.SPADES),
                new Card('K', Suite.SPADES),
                new Card('A', Suite.CLUBS)
        ));
        assertThat(HandParser.parse("5H4DJSKSAC"), is(expectedCribbageHand));
    }

    @Test
    void parseAnotherHand() {
        CribbageHand expectedCribbageHand = new CribbageHand(Arrays.asList(
                new Card('A', Suite.HEARTS),
                new Card('0', Suite.DIAMONDS),
                new Card('0', Suite.CLUBS),
                new Card('K', Suite.SPADES),
                new Card('7', Suite.HEARTS)
        ));
        assertThat(HandParser.parse("AH0D0CKS7H"), is(expectedCribbageHand));
    }
}
