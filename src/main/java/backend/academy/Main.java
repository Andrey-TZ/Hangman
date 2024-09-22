package backend.academy;

import backend.academy.classes.handlers.CommandManager;
import backend.academy.classes.handlers.INHandler;

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
            }
            CommandManager.start(input);
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
