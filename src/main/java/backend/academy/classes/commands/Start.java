package backend.academy.classes.commands;

import backend.academy.GameSession;
import backend.academy.classes.handlers.INHandler;

public class Start extends AbstractCommand {
    {
        name = "start";
        description = "начать игру";
    }

    @Override
    public void execute() {
        GameSession.startGame(INHandler.requestLevel());
    }
}
