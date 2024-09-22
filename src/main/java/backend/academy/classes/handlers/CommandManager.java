package backend.academy.classes.handlers;

import backend.academy.classes.commands.AbstractCommand;
import backend.academy.classes.commands.Exit;
import backend.academy.classes.commands.Help;
import backend.academy.classes.commands.Hint;
import backend.academy.classes.commands.Start;
import java.util.HashMap;

public class CommandManager {
    private static final HashMap<String, AbstractCommand> commands = new HashMap<>();

    static {
        commands.put("exit", new Exit());
        commands.put("help", new Help(commands));
        commands.put("hint", new Hint());
        commands.put("start", new Start());
    }

    public static void start(String command) {

        try {
            commands.get(command).execute();

        } catch (NullPointerException e) {
            OutHandler.showMessage("Не удалось обнаружить команду: ");
        }

    }
}
