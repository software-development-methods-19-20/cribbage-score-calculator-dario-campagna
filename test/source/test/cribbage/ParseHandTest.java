package test.cribbage;

import cribbage.CribbageHand;
import cribbage.HandParser;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ParseHandTest {

    @Test
    @Disabled
    void parseHand() {
        CribbageHand expectedCribbageHand = new CribbageHand();
        assertThat(HandParser.parse("5H4DJSKSAC"), is(expectedCribbageHand));
    }
}
