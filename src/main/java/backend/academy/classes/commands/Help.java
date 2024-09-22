package backend.academy.classes.commands;

import backend.academy.classes.handlers.OutHandler;
import java.util.HashMap;

public class Help extends AbstractCommand {
    private final HashMap<String, AbstractCommand> commands;

    public Help(HashMap<String, AbstractCommand> commands) {
        this.commands = commands;
        this.description = "вывести справку по доступным командам";
        this.name = "help";
    }

    @Override
    public void execute() {
        for (String command : this.commands.keySet()) {
            OutHandler.showCommands(
                new String[] {commands.get(command).name(), this.commands.get(command).description()});
        }
    }
}
