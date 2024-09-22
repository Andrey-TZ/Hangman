package backend.academy.classes.commands;

import backend.academy.intefaces.Command;
import lombok.Getter;

@Getter public abstract class AbstractCommand implements Command {
    String name;
    String description;

    @Override
    public abstract void execute();

}
