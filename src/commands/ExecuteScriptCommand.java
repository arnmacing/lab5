package commands;
//TODO execute script command


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
     * @param argument
     */

    @Override
    public boolean execute(String argument) {
        return false;
    }
}
