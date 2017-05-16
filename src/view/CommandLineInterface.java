package view;

import controller.helper.Helper;
import model.*;

/**
 * Created by think on 07.05.17.
 */
public class CommandLineInterface implements UserInterface {
    @Override
    public void printTwoPickedCards(Card card1, Card card2) {
        System.out.print("Card 1: ");
        printCard(card1);
        System.out.print("Card 2: ");
        printCard(card2);
        System.out.println("-----------------");
    }

    @Override
    public void printThirdCard(Card card3) {
        System.out.print("Card 3: ");
        printCard(card3);
    }

    private void printCard(Card card) {
        System.out.println(card.getCardNumber() + " of " + card.getCardColor());
    }
    @Override
    public void printRemainingCards(int remainingCards) {
        System.out.println(remainingCards + " left");
    }

    @Override
    public void printEndResult(PlayerInterface player) {
        System.out.println("== GAME-OVER ==");
        System.out.println("Your money: " + player.getMoney());
    }

    @Override
    public void printMoneyStatus(int money) {
        System.out.println("Your current balance " + money);
    }

    @Override
    public String getValidInput(String[] acceptableUserInput) {
        String userInput;
        do {
            System.out.print("Please type in only these keys: ");
            for (int i = 0; i < acceptableUserInput.length; i++) {
                if (i > 0) System.out.print(", ");
                System.out.print(acceptableUserInput[i]);
            }
            System.out.println();
            userInput = Helper.getUserInput().toLowerCase();
        } while(!Helper.isTextInputValid(userInput, acceptableUserInput));
        return userInput;
    }

    public void printStatusOfResources(int howManyCardsLeft, int currentMoney) {
        System.out.println("=================");
        printRemainingCards(howManyCardsLeft);
        printMoneyStatus(currentMoney);
    }
}
