package commands;

public class HelpCommand extends AbstractCommand {
    public HelpCommand() {
        super("help", "вывести справку по доступным командам");
    }

    @Override
    public String getUsage() {
        return null;
    }

    @Override
    public boolean execute(String argument) {
        return false;
    }
}
