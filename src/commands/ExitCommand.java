package commands;

public class ExitCommand extends AbstractCommand {
    public ExitCommand() {
        super("exit", "завершение программы (без сохранения в файл)");
    }

    //TODO safer exit
    @Override
    public boolean execute(String argument) {
        System.exit(0);
        return true;
    }
}
