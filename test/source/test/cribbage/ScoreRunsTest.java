package test.cribbage;

import cribbage.hand.Card;
import cribbage.hand.CribbageHand;
import cribbage.hand.Rank;
import cribbage.hand.Suite;
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
                        new Card(new Rank('9'), Suite.HEARTS),
                        new Card(new Rank('0'), Suite.DIAMONDS),
                        new Card(new Rank('J'), Suite.CLUBS),
                        new Card(new Rank('Q'), Suite.DIAMONDS)),
                new Card(new Rank('K'), Suite.HEARTS)
        );
        assertThat(new RunsRule().score(cribbageHand), is(5));
    }

    @Test
    void noRuns() {
        CribbageHand cribbageHand = new CribbageHand(
                Arrays.asList(
                        new Card(new Rank('9'), Suite.HEARTS),
                        new Card(new Rank('A'), Suite.DIAMONDS),
                        new Card(new Rank('J'), Suite.CLUBS),
                        new Card(new Rank('5'), Suite.DIAMONDS)),
                new Card(new Rank('K'), Suite.HEARTS)
        );
        assertThat(new RunsRule().score(cribbageHand), is(0));
    }
}
