package cribbage;

public class FlushRule implements Rule {

    @Override
    public int score(CribbageHand cribbageHand) {
        return pointsForFlush(cribbageHand) +
                pointsForStarterCardSuiteSameAsHandCards(cribbageHand) +
                pointsForHisNob(cribbageHand);
    }

    private int pointsForFlush(CribbageHand cribbageHand) {
        return cribbageHand.isFlush() ? 4 : 0;
    }

    private int pointsForStarterCardSuiteSameAsHandCards(CribbageHand cribbageHand) {
        return cribbageHand.isStarterCardSuiteSameAsHandCards() ? 1 : 0;
    }

    private int pointsForHisNob(CribbageHand cribbageHand) {
        return cribbageHand.hasHisNob() ? 1 : 0;
    }

}
