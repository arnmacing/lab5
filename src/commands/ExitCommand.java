package commands;

import exceptions.ExitException;
import exceptions.WrongAmountOfElementsException;
import utility.Console;

/**
 * Команда 'exit'. Завершает программу.
 */

public class ExitCommand extends AbstractCommand {
    public ExitCommand() {
        super("exit", "завершение программы (без сохранения в файл)");
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
