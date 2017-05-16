package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by think on 08.05.17.
 */
public class frenchDeck implements DeckInterface{
    List<Card> cards = new ArrayList();
    public frenchDeck() {
        for (CardSuit color : CardSuit.values()) {
            for (CardNumber number : CardNumber.values()) {
                Card card = new Card(number, color);
                this.cards.add(card);
            }
        }
    }

    public int howManyCardsLeft() {
        return this.cards.size();
    }
    public Card pickRandomCard() {
        int randomNumber = (int)Math.floor(Math.random() * howManyCardsLeft());
        return cards.remove(randomNumber);
    }
}
