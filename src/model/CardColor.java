package model;

/**
 * Created by think on 02.05.17.
 */
public enum CardColor {
    HEART("Heart"),
    SPADE("Spade"),
    CLUB("Club"),
    DIAMOND("Diamond");
    private String color;
    private CardColor(String color) {
        this.color = color;
    }
    public String getCardColor() {
        return color;
    }
}
