package backend.academy.classes.handlers;

import backend.academy.classes.HangMan;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public final class OutputManager {
    @SuppressWarnings("all") private static final PrintStream OUTPUT = new PrintStream(System.out, true,
        StandardCharsets.UTF_8);

    private OutputManager() {

    }

    public static void wrongLetter(HangMan hangMan, int tries) {
        OUTPUT.println(hangMan);
        OUTPUT.print("Попыток осталось: ");
        OUTPUT.println(tries);
    }

    public static void showWord(String word, Character[] guessedLetters) {
        StringBuilder displayedWord = new StringBuilder();
        for (char letter : word.toCharArray()) {
            if (Arrays.asList(guessedLetters).contains(letter)) {
                displayedWord.append(letter);
            } else {
                displayedWord.append('_');
            }
        }
        OUTPUT.println(displayedWord);
    }

    public static void win(String word, int tries) {
        OUTPUT.printf("Поздравляю - вы отгадали слово '%s' за %d попыток.", word, tries);
    }

    public static void loose(String word) {
        OUTPUT.printf("К сожалению вы не отгадали слово '%s'%n В следующий раз у вас точно получится!", word);

    }

    public static void showMessage(String message) {
        OUTPUT.println(message);
    }

    public static void showCommands(String name, String description) {
        OUTPUT.printf("%-10s - %s%n", name, description);
    }
}
