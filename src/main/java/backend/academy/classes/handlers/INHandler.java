package backend.academy.classes.handlers;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public final class INHandler {
    private static final Scanner SCANNER = new Scanner(System.in, StandardCharsets.UTF_8);

    private INHandler() {

    }

    public static String requestString(String message) {
        OutputManager.showMessage(message);
        if (!SCANNER.hasNextLine()) {
            System.exit(0);
        }
        return SCANNER.nextLine().trim().toLowerCase();
    }

    @SuppressWarnings("checkstyle:magicnumber")
    public static int requestDifficulty() {
        while (true) {
            try {
                int difficulty = Integer.parseInt(requestString("Введите желаемую сложность (1-3):"));
                if (difficulty < 1 || difficulty > 3) {
                    OutputManager.showMessage("Неверное значение - нужно ввести цифру от 1 до 3");
                    continue;
                }
                return difficulty;
            } catch (NumberFormatException e) {
                OutputManager.showMessage("Нужно ввести цифру от 1 до 3");
            }
        }
    }
}
