package backend.academy.classes.commands;

import backend.academy.GameSession;

public final class Exit extends AbstractCommand {
    {
        name = "exit";
        description = "завершить выполнение программы";
    }

    @Override
    public void execute() {
        GameSession.finishGame();
    }
}
