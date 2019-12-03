package cribbage;

public class Card {

    private Rank rank;
    private Suite suite;

    public Card(Rank rank, Suite suite) {
        this.rank = rank;
        this.suite = suite;
    }

    public Rank rank() {
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

        if (!rank.equals(card.rank)) return false;
        return suite == card.suite;
    }

    @Override
    public int hashCode() {
        int result = rank.hashCode();
        result = 31 * result + suite.hashCode();
        return result;
    }
}
