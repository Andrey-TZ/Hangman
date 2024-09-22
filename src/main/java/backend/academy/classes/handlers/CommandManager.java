package backend.academy.classes.handlers;

import backend.academy.classes.commands.AbstractCommand;
import backend.academy.classes.commands.Exit;
import backend.academy.classes.commands.Help;
import backend.academy.classes.commands.Hint;
import backend.academy.classes.commands.Start;
import java.util.HashMap;

public class CommandManager {
    private static final HashMap<String, AbstractCommand> COMMANDS = new HashMap<>();

    static {
        COMMANDS.put("exit", new Exit());
        COMMANDS.put("help", new Help(COMMANDS));
        COMMANDS.put("hint", new Hint());
        COMMANDS.put("start", new Start());
    }

    private CommandManager() {
    }

    public static void start(String command) {

        try {
            COMMANDS.get(command).execute();

        } catch (NullPointerException e) {
            OutHandler.showMessage("Не удалось обнаружить команду: ");
        }

    }
}
