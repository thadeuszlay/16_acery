package model;

/**
 * Created by think on 02.05.17.
 */
public class Card {
    private CardNumber number;
    private CardSuit color;

    public Card(CardNumber number, CardSuit color) {
        this.number = number;
        this.color = color;
    }

    public String getCardNumber() {
        return number.getCardNumber();
    }
    public int getCardNumberValue() {
        return number.getCardValue();
    }
    public String getCardColor() {
        return color.getCardColor();
    }
}
