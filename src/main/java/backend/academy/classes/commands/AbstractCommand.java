package backend.academy.classes.commands;

import backend.academy.intefaces.Command;

public abstract class AbstractCommand implements Command {
    String name;
    String description;

    @Override
    public abstract void execute();

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
