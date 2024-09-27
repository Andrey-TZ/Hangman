package backend.academy;

import backend.academy.classes.GameSession;
import backend.academy.classes.handlers.CommandManager;
import backend.academy.classes.handlers.INHandler;
import backend.academy.classes.handlers.OutputManager;

public final class Main {
    private static boolean gameStarted = false;
    private static boolean gameEnded = false;

    private Main() {
    }

    public static void main(String[] args) {
        String input;
        while (!gameStarted) {
            input = INHandler.requestString("Введите команду:");
            CommandManager.start(input);
        }
        while (!gameEnded) {
            input = INHandler.requestString("Введите букву или команду:");
            if (GameSession.guessLetter(input)) {
                continue;
            } else if (CommandManager.start(input)) {
                continue;
            }
            OutputManager.showMessage("Введено больше одной буквы");

        }
        GameSession.finishGame();
    }

    public static void startGame() {
        gameStarted = true;
    }

    public static void endGame() {
        gameEnded = true;
    }

}
