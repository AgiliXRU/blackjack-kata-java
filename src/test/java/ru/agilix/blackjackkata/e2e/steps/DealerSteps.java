package ru.agilix.blackjackkata.e2e.steps;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.*;

public class DealerSteps {
    private static final String HOST = "localhost";
    private static final String PORT = "8080";
    private ArrayList<String> hand = new ArrayList<>();

    @Допустим("у дилера на руках {string}")
    public void dealerHasCards(String hand) {
        this.hand.add(hand);
    }

    @Когда("он {string} из колоды")
    public void dealerGetsAnotherCard(String card) {
        this.hand.add(card);
    }

    @Тогда("{string}")
    public void canHit(String result) throws IOException {
        JsonObject json = getJSONRequest("http://"+HOST+":"+PORT+"/dealer/action?" + handToGetParams());

        JsonElement canHit = json.get("can hit");

        assertResult(result, canHit.getAsBoolean());
    }

    private void assertResult(String expected, boolean result) {
        if (expected.equals("может взять")) {
            assertTrue(result);
        } else {
            assertFalse(result);
        }
    }

    private JsonObject getJSONRequest(String urlString) throws IOException {
        String result = "";
        URL url = new URL(urlString);

        Scanner scanner = new Scanner(url.openStream());
        String response = scanner.useDelimiter("\\Z").next();
        JsonObject jsonObject = JsonParser.parseString(response).getAsJsonObject();
        scanner.close();

        return jsonObject;
    }

    private String handToGetParams() {
        return this.hand.stream().map(c -> "card=" + c).reduce("", (x, y) -> x + "&" + y);
    }

}
