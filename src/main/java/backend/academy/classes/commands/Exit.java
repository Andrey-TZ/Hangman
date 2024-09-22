package backend.academy.classes.commands;

import backend.academy.GameSession;

public class Exit extends AbstractCommand {
    {
        name = "exit";
        description = "завершить выполнение программы";
    }

    @Override
    public void execute() {
        GameSession.finishGame();
    }
}
