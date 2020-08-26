package ru.agilix.blackjackkata.domain;

import java.util.ArrayList;

public class Dealer {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean canHit(ArrayList<Card> cards) {
        int result = 0;
        int reserve = 0;
        for (Card card : cards) {
            if (card.getValue().size() > 1) {
                if (result + card.getValue().get(0) > 21) {
                    result += card.getValue().get(1);
                } else {
                    result += card.getValue().get(0);
                    reserve += 10;
                }
            } else {
                result += card.getValue().get(0);
            }
        }
        return result < 17;
    }

}
