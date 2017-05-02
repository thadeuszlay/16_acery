import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by think on 02.05.17.
 */
public class Main {
    public static void main(String[] args) {
        // load
        Player player = new Player();
        List<Card> deck = new ArrayList<>();
        for (CardColor color : CardColor.values()) {
            for (CardNumber number : CardNumber.values()) {
                Card card = new Card(number, color);
                deck.add(card);
            }
        }

        while(true) {
            System.out.println("---------------------");
            System.out.println("remaining cards " + deck.size());
            if (deck.size() < 2 ) {
                System.out.println("Game over. Not enough cards");
                break;
            }
            if (player.getMoney() <= 0) {
                System.out.println("Game over. Not enough money");
                break;
            }
            // pick two
            Card firstPick = Dealer.pickRandomCardFrom(deck);
            Card secondPick = Dealer.pickRandomCardFrom(deck);
            Card thirdPick = new Card();
            //show two cards
            System.out.println("First card ");
            System.out.println(firstPick.getCardNumber() + " of " + firstPick.getCardColor());
            System.out.println("----");
            System.out.println("Second card ");
            System.out.println(secondPick.getCardNumber() + " of " + secondPick.getCardColor());

            System.out.println("Do you want to set?");
            String userInput = getUserInput();
            if (userInput.equals("y")) {
                System.out.println("How much money do you want to bet?");
                System.out.println("You got that amount of money " + player.getMoney());
                int playerBet = Integer.parseInt(getUserInput());
                try {
                    player.withdrawMoney(playerBet);
                } catch (Exception e) {
                    System.out.println("You don't have enough money");
                    e.printStackTrace();
                    break;
                }
                thirdPick = Dealer.pickRandomCardFrom(deck);
                int compareThis = thirdPick.getCardNumberValue();
                int maxValue = Math.max(firstPick.getCardNumberValue(), secondPick.getCardNumberValue());
                int minValue = Math.min(firstPick.getCardNumberValue(), secondPick.getCardNumberValue());
                System.out.println("Result:");
                System.out.println(thirdPick.getCardNumber() + " of " + thirdPick.getCardColor());

                if (compareThis >= minValue && compareThis <= maxValue) {
                    System.out.println("You won!");
                    try{
                        player.depositMoney(2 * playerBet);
                    } catch (Exception e) {
                        System.out.println("Invalid amount of money");
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("though luck!");
                }
            }
        }

    }

    private static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


}
