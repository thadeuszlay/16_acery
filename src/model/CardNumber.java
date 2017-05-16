package model;

/**
 * Created by think on 02.05.17.
 */
public enum CardNumber {
    ACE("Ace", 1),
    TWO("Two", 2),
    THREE("Three", 3),
    FOUR("Four", 4),
    FIVE("Five", 5),
    SIX("Six", 6),
    SEVEN("Seven", 7),
    EIGHT("Eight", 8),
    NINE("Nine", 9),
    TEN("Ten", 10),
    JACK("Jack", 11),
    QUEEN("Queen", 12),
    KING("King", 13);
    private String number;
    private int value;
    CardNumber(String number, int value) {
        this.number = number;
        this.value = value;
    }
    public String getCardNumber(){return number;}
    public int getCardValue() {return value;}
}


