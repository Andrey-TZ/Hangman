package backend.academy.classes.handlers;

import backend.academy.classes.HangMan;
import java.util.ArrayList;

public class OutHandler {

    private OutHandler(){

    }

    public static void wrongLetter(HangMan hangMan, int tries) {
        System.out.println(hangMan);
        System.out.print("Попыток осталось: ");
        System.out.println(tries);
    }

    public static void showWord(String word, ArrayList<Character> guessedLetters) {
        for (char letter : word.toCharArray()) {
            if (guessedLetters.contains(letter)) {
                System.out.print(letter);
            } else {
                System.out.print("_");
            }
        }
        System.out.println(" ");
    }

    public static void win(String word, int tries) {
        System.out.printf("Поздравляю - вы отгадали слово '%s' за %d попыток.", word, tries);
    }

    public static void loose(String word) {
        System.out.printf("К сожалению вы не отгадали слово '%s'\n В следующий раз у вас точно получится!", word);

    }

    public static void showMessage(String message) {
        System.out.println(message);
    }

    public static void showCommands(String[] commandsInfo) {
        System.out.printf("%-41s - %s\n", commandsInfo[0], commandsInfo[1]);
    }
}
