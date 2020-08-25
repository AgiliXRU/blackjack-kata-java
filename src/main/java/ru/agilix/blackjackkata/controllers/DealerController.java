package ru.agilix.blackjackkata.controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.agilix.blackjackkata.domain.Card;
import ru.agilix.blackjackkata.domain.Dealer;
import ru.agilix.blackjackkata.domain.Hand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
public class DealerController {

    @RequestMapping(method = {RequestMethod.GET}, value = {"/dealer/action"})
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getNextAction(@RequestParam String card) {
        Dealer dealer = new Dealer();
        Map<String, Object> body = new HashMap<>();

        ArrayList<Card> hand = Hand.parse(card);

        body.put("can hit", dealer.canHit(hand));
        return new ResponseEntity<>(body, HttpStatus.OK);
    }
}
