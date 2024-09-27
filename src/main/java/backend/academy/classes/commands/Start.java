package backend.academy.classes.commands;

import backend.academy.classes.GameSession;
import backend.academy.classes.handlers.INHandler;

public final class Start extends AbstractCommand {
    {
        name = "start";
        description = "начать игру";
    }

    @Override
    public void execute() {
        GameSession.startGame(INHandler.requestLevel());
    }
}
