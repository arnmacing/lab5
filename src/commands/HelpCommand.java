package commands;

import exceptions.WrongAmountOfElementsException;
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
     *
     * @return Статус выхода из команды.
     */

    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfElementsException();
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Использование: '" + getName() + "'");
        }
        return false;
    }
}
