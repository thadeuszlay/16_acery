package view;

import model.Card;
import model.PlayerInterface;

/**
 * Created by think on 07.05.17.
 */
public interface UserInterface {
    void printTwoPickedCards(Card card1, Card card2);
    void printThirdCard(Card card3);
    void printRemainingCards(int remainingCards);
    void printEndResult(PlayerInterface player);
    void printMoneyStatus(int money);
    String getValidInput(String[] acceptableInput);
    void printStatusOfResources(int howManyCardsLeft, int currentMoney);
}
