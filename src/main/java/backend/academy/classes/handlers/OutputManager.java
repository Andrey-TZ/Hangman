package backend.academy.classes.handlers;

import backend.academy.classes.HangMan;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Set;

public final class OutputManager {
    @SuppressWarnings("all") private static PrintStream OUTPUT = new PrintStream(System.out, true,
        StandardCharsets.UTF_8);

    private OutputManager() {

    }

    public static void setOut(PrintStream out) {
        OUTPUT = out;
    }

    public static void showHangMan(HangMan hangMan, int tries) {
        OUTPUT.println(hangMan + "Попыток осталось: " + tries);
    }

    public static void showWord(String word, Set<Character> guessedLetters) {
        StringBuilder displayedWord = new StringBuilder();
        for (char letter : word.toCharArray()) {
            if (guessedLetters.contains(letter)) {
                displayedWord.append(letter);
            } else {
                displayedWord.append('_');
            }
        }
        OUTPUT.println(displayedWord);
    }

    public static void win(String word, int tries) {
        OUTPUT.printf("Поздравляю - вы отгадали слово '%s'. Неправильных букв: %d.", word, tries);
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
