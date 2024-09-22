package backend.academy.classes.commands;

import backend.academy.GameSession;

public final class Hint extends AbstractCommand {

    {
        name = "hint";
        description = "получить подсказку";
    }

    @Override
    public void execute() {
        GameSession.giveHint();
    }
}
