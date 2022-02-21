package commands;

import exceptions.WrongAmountOfElementsException;
import utility.Console;

/**
 * Команда 'execute_script file_name'. Считывает и исполняет скрипт из указанного файла.
 */

public class ExecuteScriptCommand extends AbstractCommand {
    public ExecuteScriptCommand() {
        super("execute_script file_name", "осчитать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
    }

    /**
     * Выполнение команды.
     * @return Статус выхода из команды.
     */

    //todo execute script
    @Override
    public boolean execute(String argument) {
        try {
            if (stringArgument.isEmpty() || objectArgument != null) throw new WrongAmountOfElementsException();
            return true;
        } catch (WrongAmountOfElementsException exception) {
            ResponseOutputer.appendln("Использование: '" + getName() + " " + getUsage() + "'");
        }
        return false;
    }
}
