package backend.academy.classes.handlers;

import backend.academy.classes.Command;
import java.util.HashMap;
import org.apache.commons.lang3.tuple.Pair;

public final class CommandManager {
    private static final HashMap<String, Pair<Command, String>> COMMANDS = new HashMap<>();

    public static void setCommand(String name, Command command, String description) {
        COMMANDS.put(name, Pair.of(command, description));
    }

    private CommandManager() {
    }

    public static void help() {
        for (String key : COMMANDS.keySet()) {
            OutputManager.showCommands(key, COMMANDS.get(key).getRight());
        }
    }

    public static boolean start(String command) {
        if (COMMANDS.containsKey(command)) {
            COMMANDS.get(command).getLeft().execute();
            return true;
        } else {
            OutputManager.showMessage("Не удалось обнаружить команду");
            return false;
        }

    }
}
