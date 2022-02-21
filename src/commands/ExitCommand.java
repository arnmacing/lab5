package commands;

/**
 * Команда 'exit'. Завершает программу.
 */

public class ExitCommand extends AbstractCommand {
    public ExitCommand() {
        super("exit", "завершение программы (без сохранения в файл)");
    }

    /**
     * Выполнение команды.
     * @return Статус выхода из команды.
     * @param argument
     */

    //TODO safer exit
    @Override
    public boolean execute(String argument) {
        System.exit(0);
        return true;
    }
}
