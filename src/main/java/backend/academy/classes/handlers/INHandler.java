package backend.academy.classes.handlers;

import java.util.InputMismatchException;
import java.util.Scanner;

public class INHandler {
    private static final Scanner SCANNER = new Scanner(System.in);

    private INHandler() {

    }

    public static String requestString(String message) throws NumberFormatException {
        System.out.print(message);
        if (!SCANNER.hasNextLine()) {
            System.exit(0);
        }

        return SCANNER.nextLine().trim().toLowerCase();
    }

    public static int requestLevel() {
        while (true) {
            if (!SCANNER.hasNextLine()) {
                System.exit(0);
            }
            try {
                OutHandler.showMessage("Введите желаемую сложность (1-3): ");
                return SCANNER.nextInt();
            } catch (InputMismatchException e) {
                OutHandler.showMessage("Нужно ввести цифру от 1 до 3");
            }
        }
    }
}
