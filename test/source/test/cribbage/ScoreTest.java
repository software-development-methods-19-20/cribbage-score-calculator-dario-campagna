package test.cribbage;

import cribbage.Card;
import cribbage.CribbageHand;
import cribbage.Scorer;
import cribbage.Suite;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ScoreTest {

    @Test
    void twoPointsForAPairOfCardsOfAKind() {
        CribbageHand cribbageHand = new CribbageHand(Arrays.asList(
                new Card('2', Suite.DIAMOND),
                new Card('A', Suite.DIAMOND),
                new Card('2', Suite.CLUBS),
                new Card('7', Suite.DIAMOND),
                new Card('9', Suite.DIAMOND)
        ));
        assertThat(Scorer.score(cribbageHand), is(2));
    }
}
