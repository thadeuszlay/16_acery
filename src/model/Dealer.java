package model;

import java.util.List;

/**
 * Created by think on 02.05.17.
 */
public class Dealer {
    public static Card pickRandomCardFrom(List<Card> deck) {
        int randomNumber = (int)Math.floor(Math.random() * deck.size());
        Card pickedCard = deck.get(randomNumber);
        deck.remove(randomNumber);
        return pickedCard;
    }
}
