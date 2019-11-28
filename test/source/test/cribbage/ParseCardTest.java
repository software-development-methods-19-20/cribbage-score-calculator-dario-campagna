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
        Card card = CardParser.parseCard("5H");
        assertThat(card.rank(), is('5'));
    }

    @Test
    void parseCardWithRankAce() {
        Card card = CardParser.parseCard("AD");
        assertThat(card.rank(), is('A'));
    }

    @Test
    void parseCardOfHearts() {
        Card card = CardParser.parseCard("5H");
        assertThat(card.suite(), is(Suite.HEART));
    }

    @Test
    void parsCardOfDiamonds() {
        Card card = CardParser.parseCard("AD");
        assertThat(card.suite(), is(Suite.DIAMOND));
    }

    @Test
    void parseCardOfClubs() {
        Card card = CardParser.parseCard("2C");
        assertThat(card.suite(), is(Suite.CLUBS));
    }

    @Test
    void parseCardOfSpades() {
        Card card = CardParser.parseCard("2S");
        assertThat(card.suite(), is(Suite.SPADES));
    }
}
