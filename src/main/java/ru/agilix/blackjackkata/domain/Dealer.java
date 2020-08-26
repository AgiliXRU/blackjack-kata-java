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
        return sum(cards) < 17;
    }

    private int sum(ArrayList<Card> cards) {
        int sum = 0;
        int countA = 0;
        for (Card card : cards) {
            if (card.getCard().equals("A")) {
                countA++;    
            } 
            sum += card.getValue();
        }

        while ((countA > 0) && (sum > 21)) {
            sum = sum-10;
            countA--;
        }
        return sum;
    }
}
