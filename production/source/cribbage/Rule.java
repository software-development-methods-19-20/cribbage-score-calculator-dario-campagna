package cribbage;

import java.util.List;

public interface Rule {

    int applyTo(List<Card> handCards, Card starterCard);

}
