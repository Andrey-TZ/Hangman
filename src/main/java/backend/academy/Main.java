package backend.academy;

import backend.academy.classes.Command;
import backend.academy.classes.GameSession;
import backend.academy.classes.handlers.CommandManager;

public final class Main {

    private Main() {
    }

    public static void main(String[] args) {
        GameSession gameSession = new GameSession();
        setUpCommands(gameSession);
        gameSession.run();
    }

    private static void setUpCommands(GameSession gameSession) {
        Command start = gameSession::startGame;
        Command hint = gameSession::giveHint;
        Command exit = gameSession::finishGame;
        Command help = CommandManager::help;

        CommandManager.setCommand("help", help, "вывести справку по доступным командам");
        CommandManager.setCommand("start", start, "начать игру");
        CommandManager.setCommand("hint", hint, "получить подсказку");
        CommandManager.setCommand("exit", exit, "завершить выполнение программы");
    }

}
