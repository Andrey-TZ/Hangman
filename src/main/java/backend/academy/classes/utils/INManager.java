package backend.academy.classes.utils;

import java.util.Scanner;

public class INManager {
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
            System.out.println("Требуется ввести букву");
        }
    }
}
