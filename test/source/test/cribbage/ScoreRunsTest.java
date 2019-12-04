package test.cribbage;

import cribbage.hand.*;
import cribbage.rules.RunsRule;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ScoreRunsTest {

    @Test
    void fivePointsForRunOfFive() {
        CribbageHand cribbageHand = new CribbageHand(
                Arrays.asList(
                        new Card(Rank.create('9'), Suite.HEARTS),
                        new Card(Rank.create('0'), Suite.DIAMONDS),
                        new Card(Rank.create('J'), Suite.CLUBS),
                        new Card(Rank.create('Q'), Suite.DIAMONDS)),
                new Card(Rank.create('K'), Suite.HEARTS)
        );
        assertThat(new RunsRule().score(cribbageHand), is(5));
    }

    @Test
    void anotherRunOfFive() {
        CribbageHand cribbageHand = new CribbageHand(
                Arrays.asList(
                        new Card(Rank.create('9'), Suite.HEARTS),
                        new Card(Rank.create('0'), Suite.DIAMONDS),
                        new Card(Rank.create('J'), Suite.CLUBS),
                        new Card(Rank.create('Q'), Suite.DIAMONDS)),
                new Card(Rank.create('8'), Suite.HEARTS)
        );
        assertThat(new RunsRule().score(cribbageHand), is(5));
    }

    @Test
    void noRuns() {
        CribbageHand cribbageHand = new CribbageHand(
                Arrays.asList(
                        new Card(Rank.create('9'), Suite.HEARTS),
                        new Card(Rank.create('A'), Suite.DIAMONDS),
                        new Card(Rank.create('J'), Suite.CLUBS),
                        new Card(Rank.create('5'), Suite.DIAMONDS)),
                new Card(Rank.create('K'), Suite.HEARTS)
        );
        assertThat(new RunsRule().score(cribbageHand), is(0));
    }

    @Test
    void fourPointsForARunOfFour() {
        CribbageHand cribbageHand = new CribbageHand(
                Arrays.asList(
                        new Card(Rank.create('2'), Suite.HEARTS),
                        new Card(Rank.create('3'), Suite.DIAMONDS),
                        new Card(Rank.create('4'), Suite.CLUBS),
                        new Card(Rank.create('5'), Suite.DIAMONDS)),
                new Card(Rank.create('K'), Suite.HEARTS)
        );
        assertThat(new RunsRule().score(cribbageHand), is(4));
    }

    @Test
    void threePointsForARunOfThree() {
        CribbageHand cribbageHand = new CribbageHand(
                Arrays.asList(
                        new Card(Rank.create('0'), Suite.HEARTS),
                        new Card(Rank.create('3'), Suite.DIAMONDS),
                        new Card(Rank.create('4'), Suite.CLUBS),
                        new Card(Rank.create('5'), Suite.DIAMONDS)),
                new Card(Rank.create('K'), Suite.HEARTS)
        );
        assertThat(new RunsRule().score(cribbageHand), is(3));
    }

    @Test
    void sixPointsForTwoRunsOfThree() {
        CribbageHand cribbageHand = new CribbageHand(
                Arrays.asList(
                        new Card(Rank.create('3'), Suite.HEARTS),
                        new Card(Rank.create('3'), Suite.DIAMONDS),
                        new Card(Rank.create('4'), Suite.CLUBS),
                        new Card(Rank.create('5'), Suite.DIAMONDS)),
                new Card(Rank.create('K'), Suite.HEARTS)
        );
        assertThat(new RunsRule().score(cribbageHand), is(6));
    }
}
