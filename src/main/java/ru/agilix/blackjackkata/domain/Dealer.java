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
        return cards.stream().mapToInt(Card::getValue).sum() < 17 ;
    }

}
