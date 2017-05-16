package controller;

import controller.helper.Helper;
import model.*;
import view.UserInterface;

/**
 * Created by think on 07.05.17.
 */
public class Game {
    final UserInterface ui;
    final DeckInterface deck;
    final PlayerInterface player;

    final String[] acceptableInput = {"y", "n", "q"};
    public Game(UserInterface ui, DeckInterface deck, PlayerInterface player) {
        this.ui = ui;
        this.deck = deck;
        this.player = player;
    }

    public void start() {
        while(true) {
            if (!hasEnoughResources()) {
                ui.printEndResult(player);
                break;
            }
            ui.printStatusOfResources(deck.howManyCardsLeft(), player.getMoney());
            Card[] cardTupel = pick2RandomCards();
            ui.printTwoPickedCards(cardTupel[0], cardTupel[1]);
            String userInput = askHowUserWantsToContinue();
            if (userInput.equals("y")) {
                System.out.println("How much money do you want to bet?");
                int playerBet = getValidBetAmount(player.getMoney());
                betOnThirdCard(cardTupel, playerBet);
            } else if (userInput.equals("q")) {
                System.exit(1);
            } else if (userInput.equals("n")) {
                continue;
            } else {
                System.out.println("unknown selection");
            }
        }
    }

    private int getValidBetAmount(int max) {
        String userInputTemp;
        do {
            Helper.println("Please type in integer between 0 (exclusive) and " + max + " (inclusive)");
            userInputTemp = Helper.getUserInput();
        } while (!validBetAmount(userInputTemp, max));
        return Integer.parseInt(userInputTemp);
    }

    private boolean validBetAmount(String userInputTemp, int maxAmount) {
        if(!Helper.inputIsNotInteger(userInputTemp)) {
          return (Integer.parseInt(userInputTemp) > 0 && Integer.parseInt(userInputTemp) <= maxAmount);
        }
        return false;
    }

    private void betOnThirdCard(Card[] cardTupel, int playerBet) {
        Card thirdPickedCard = deck.pickRandomCard();
        ui.printThirdCard(thirdPickedCard);
        if(userWins(cardTupel, thirdPickedCard)) {
            System.out.println("You won!");
            player.depositMoney(playerBet);
        } else {
            System.out.println("You lost!");
            player.withdrawMoney(playerBet);
        }
    }

    private boolean userWins(Card[] cardTupel, Card thirdPickedCard) {
        int valueOfThirdCard = thirdPickedCard.getCardNumberValue();
        int maxValue = Math.max(cardTupel[0].getCardNumberValue(), cardTupel[1].getCardNumberValue());
        int minValue = Math.min(cardTupel[0].getCardNumberValue(), cardTupel[1].getCardNumberValue());
        return (valueOfThirdCard >= minValue && valueOfThirdCard <= maxValue);
    }

    private String askHowUserWantsToContinue() {
        Helper.println("Do you want to bet?");
        return ui.getValidInput(acceptableInput);
    }

    private boolean hasEnoughResources() {
        if (deck.howManyCardsLeft() < 3 ) {
            System.out.println("Game over. Not enough cards");
            return false;
        }
        if (player.getMoney() <= 0) {
            System.out.println("Game over. Not enough money");
            return false;
        }
        return true;
    }

    private Card[] pick2RandomCards() {
        Card card1 = deck.pickRandomCard();
        Card card2 = deck.pickRandomCard();
        return new Card[]{card1, card2};
    }
}