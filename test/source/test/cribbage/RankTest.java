package test.cribbage;

import cribbage.hand.Rank;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class RankTest {

    @Test
    void aceHasValue1() {
        assertThat(Rank.create('A').toInt(), is(1));
    }

    @Test
    void twoHasValue2() {
        assertThat(Rank.create('2').toInt(), is(2));
    }

    @Test
    void tenHasValue10() {
        assertThat(Rank.create('0').toInt(), is(10));
    }

    @Test
    void jackHasValue10() {
        assertThat(Rank.create('J').toInt(), is(10));
    }

    @Test
    void queenHasValue10() {
        assertThat(Rank.create('Q').toInt(), is(10));
    }

    @Test
    void kingHasValue10() {
        assertThat(Rank.create('K').toInt(), is(10));
    }

}
