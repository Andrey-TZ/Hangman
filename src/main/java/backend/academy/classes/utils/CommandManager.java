package backend.academy.classes.utils;

import backend.academy.classes.commands.AbstractCommand;
import backend.academy.classes.commands.Help;
import backend.academy.intefaces.Command;
import java.util.HashMap;
import java.util.Scanner;

public class CommandManager {
    private static final HashMap<String, AbstractCommand> commands = new HashMap<>();

    static {
        commands.put("help", new Help(commands));
    }

    public static void start(String command) {

        try {
            commands.get(command).execute();

        } catch (NullPointerException e) {
            System.out.println("Не удалось обнаружить команду: ");
        }

    }
}
