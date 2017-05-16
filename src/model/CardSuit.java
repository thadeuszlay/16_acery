package model;

/**
 * Created by think on 02.05.17.
 */
public enum CardSuit {
    HEART("Hearts"),
    SPADE("Spades"),
    CLUB("Clubs"),
    DIAMOND("Diamonds");
    private String color;
    CardSuit(String color) {
        this.color = color;
    }
    public String getCardColor() {
        return color;
    }
}
