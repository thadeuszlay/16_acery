import view.CommandLineInterface;
import controller.Game;
import view.UserInterface;
import model.*;

/**
 * Created by think on 02.05.17.
 */
public class Main {
    public static void main(String[] args) {
        PlayerInterface player = new Player(100);
        DeckInterface deck = new frenchDeck();
        UserInterface ui = new CommandLineInterface();
        Game game = new Game(ui, deck, player);
        game.start();
    }
}
