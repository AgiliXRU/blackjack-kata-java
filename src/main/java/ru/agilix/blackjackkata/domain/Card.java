package ru.agilix.blackjackkata.domain;

import java.util.*;

public class Card {

    private final List<Integer> value;
    private Map<String, List<Integer>> values = new HashMap<>();

    private final String card;

    public List<Integer> getValue() {
        return value;
    }

    public Card(String card) {
        this.card = card;
        initValues();
        this.value = calculateValue(card);
    }

    private void initValues() {
        values.put("Q", Collections.singletonList(10));
        values.put("A", Arrays.asList(11, 1));
        values.put("7", Collections.singletonList(7));
        values.put("6", Collections.singletonList(6));
    }

    private List<Integer> calculateValue(String cart) {
        return values.get(cart);
    }

    @Override
    public String toString() {
        return "[" + card + "]";
    }
}
