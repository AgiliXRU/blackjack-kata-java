package ru.agilix.blackjackkata.domain;

import java.util.ArrayList;
import java.util.Arrays;

public class Hand {

    public static ArrayList<Card> parse(String cardsString) {

        ArrayList<Card> result = new ArrayList<>();

        Arrays.stream(cardsString.split(","))
              .forEach( card -> result.add(new Card(card.toUpperCase())) );

        return result;
    }
}
