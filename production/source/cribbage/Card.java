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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (rank != card.rank) return false;
        return suite == card.suite;
    }

    @Override
    public int hashCode() {
        int result = rank;
        result = 31 * result + suite.hashCode();
        return result;
    }
}
