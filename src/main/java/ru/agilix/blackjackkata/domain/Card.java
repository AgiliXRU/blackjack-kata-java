package ru.agilix.blackjackkata.domain;

import java.util.HashMap;
import java.util.Map;

public class Card {

    private final int value;
    private Map<String, Integer> values = new HashMap<>();

    private final String card;

    public int getValue() {
        return value;
    }

    public Card(String card) {
        this.card = card;
        initValues();
        this.value = calculateValue(card);
    }

    private void initValues() {
        values.put("Q",10);
        values.put("7",7);
        values.put("6",6);
    }

    private int calculateValue(String cart) {
        return values.get(cart);
    }

    @Override
    public String toString() {
        return "["+card+"]";
    }
}
