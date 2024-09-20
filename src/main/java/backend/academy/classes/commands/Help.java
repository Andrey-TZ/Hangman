package backend.academy.classes.commands;

import java.util.HashMap;

public class Help extends AbstractCommand{
    private final HashMap<String, AbstractCommand> commands;

    public Help(HashMap<String, AbstractCommand> commands) {
        this.commands = commands;
        this.description = "вывести справку по доступным командам";
        this.name = "help";
    }
    @Override
    public void execute() {

    }
}
