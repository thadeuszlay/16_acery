package controller.helper;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by think on 08.05.17.
 */
public class Helper {

    public static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void println(String message) {
        System.out.println(message);
    }

    public static boolean inputIsNotInteger(String userInput) {
        try {
            Integer.parseInt(userInput);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }


    public static boolean isTextInputValid(String input, String[] acceptableInput) {
        return Arrays.stream(acceptableInput).anyMatch(input::equals);
    }

}
