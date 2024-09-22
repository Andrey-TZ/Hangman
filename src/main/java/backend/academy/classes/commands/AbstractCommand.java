package backend.academy.classes.commands;

import lombok.Getter;

@Getter public abstract class AbstractCommand {
    String name;
    String description;

    public abstract void execute();

}
