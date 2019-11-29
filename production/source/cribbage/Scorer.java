package cribbage;

public class Scorer {
    public static Integer score(CribbageHand cribbageHand) {
        return cribbageHand.scoreWith(new PairsRule());
    }
}
