package test.cribbage;

import cribbage.hand.Rank;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class RankTest {

    @Test
    void aceHasValue1() {
        assertThat(new Rank('A').toInt(), is(1));
    }

    @Test
    void twoHasValue2() {
        assertThat(new Rank('2').toInt(), is(2));
    }

    @Test
    void tenHasValue10() {
        assertThat(new Rank('0').toInt(), is(10));
    }

    @Test
    void jackHasValue10() {
        assertThat(new Rank('J').toInt(), is(10));
    }

    @Test
    void queenHasValue10() {
        assertThat(new Rank('Q').toInt(), is(10));
    }

    @Test
    void kingHasValue10() {
        assertThat(new Rank('K').toInt(), is(10));
    }

    @Test
    void aceIsLessThanOtherRanks() {
        Rank ace = new Rank('A');
        Rank two = new Rank('2');
        assertTrue(ace.compareTo(two) < 0);
        assertTrue(two.compareTo(ace) > 0);
    }

    @Test
    void tenIsGreaterThan9AndLessThanJack() {
        Rank nine = new Rank('9');
        Rank ten = new Rank('0');
        Rank jack = new Rank('J');
        assertTrue(nine.compareTo(ten) < 0);
        assertTrue(ten.compareTo(jack) < 0);
    }
}
