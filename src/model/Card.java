package model;

/**
 * Created by think on 02.05.17.
 */
public class Card {
    private CardNumber number;
    private CardColor color;

    public Card() {};
    public Card(CardNumber number, CardColor color) {
        this.number = number;
        this.color = color;
    }

    public CardNumber getNumber() {
        return number;
    }

    public String getCardNumber() {
        return number.getCardNumber();
    }

    public int getCardNumberValue() {
        return number.getCardValue();
    }

    public void setNumber(CardNumber number) {
        this.number = number;
    }

    public CardColor getColor() {
        return color;
    }

    public String getCardColor() {
        return color.getCardColor();
    }

    public void setColor(CardColor color) {
        this.color = color;
    }


}
