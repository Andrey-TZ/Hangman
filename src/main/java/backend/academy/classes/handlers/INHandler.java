package backend.academy.classes.handlers;

import java.util.InputMismatchException;
import java.util.Scanner;

public class INHandler {
    private static final Scanner scanner = new Scanner(System.in);

    public static String requestString(String message) throws NumberFormatException {
        System.out.print(message);
        if (!scanner.hasNextLine()) {
            System.exit(0);
        }

        return scanner.nextLine().trim().toLowerCase();
    }

    public static char requestLetter() {
        while (true) {
            if (!scanner.hasNextLine()) {
                System.exit(0);
            }
            char[] res = requestString("Введите букву: ").toCharArray();
            if (res.length == 1) {
                return res[0];
            }
            OutHandler.showMessage("Требуется ввести букву");
        }
    }

    public static int requestLevel() {
        while (true) {
            if (!scanner.hasNextLine()) {
                System.exit(0);
            }
            try {
                OutHandler.showMessage("Введите желаемую сложность (1-3): ");
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                OutHandler.showMessage("Нужно ввести цифру от 1 до 3");
            }
        }
    }
}
