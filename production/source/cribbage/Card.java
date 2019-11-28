package cribbage;

public class Card {

    private char rank;
    private Suite suite;

    public Card(char rank, Suite suite) {
        this.rank = rank;
        this.suite = suite;
    }

    public char rank() {
        return rank;
    }

    public Suite suite() {
        return suite;
    }
}
