package commands;

import utility.CommandManager;
import utility.Console;

public class HelpCommand extends AbstractCommand {
    private CommandManager commandManager;
    public HelpCommand() {
        super("help", "вывести справку по доступным командам");
    }



    @Override
    public boolean execute(String argument) {
        Console.println(commandManager.getCommands());
        return true;
    }
}
