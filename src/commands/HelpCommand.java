package commands;

import utility.CommandManager;
import utility.Console;

/**
 * Команда 'help'. Вывод справки по доступным командам.
 */

public class HelpCommand extends AbstractCommand {
    private CommandManager commandManager;
    public HelpCommand() {
        super("help", "вывести справку по доступным командам");
    }

    /**
     * Выполнение команды.
     * @return Статус выхода из команды.
     * @param argument
     */

    @Override
    public boolean execute(String argument) {
        Console.println(commandManager.getCommands());
        return true;
    }
}
