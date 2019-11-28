package test.cribbage;

import cribbage.Card;
import cribbage.CardParser;
import cribbage.Suite;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ParseCardTest {

    @Test
    void parseCardWithRankFive() {
        Card card = CardParser.parse("5H");
        assertThat(card.rank(), is('5'));
    }

    @Test
    void parseCardWithRankAce() {
        Card card = CardParser.parse("AD");
        assertThat(card.rank(), is('A'));
    }

    @Test
    void parseCardOfHearts() {
        Card card = CardParser.parse("5H");
        assertThat(card.suite(), is(Suite.HEART));
    }

    @Test
    void parsCardOfDiamonds() {
        Card card = CardParser.parse("AD");
        assertThat(card.suite(), is(Suite.DIAMOND));
    }

    @Test
    void parseCardOfClubs() {
        Card card = CardParser.parse("2C");
        assertThat(card.suite(), is(Suite.CLUBS));
    }

    @Test
    void parseCardOfSpades() {
        Card card = CardParser.parse("2S");
        assertThat(card.suite(), is(Suite.SPADES));
    }

    @Test
    void parseCard() {
        Card expectedCard = new Card('3', Suite.CLUBS);
        assertThat(CardParser.parse("3C"), is(expectedCard));
    }
}
