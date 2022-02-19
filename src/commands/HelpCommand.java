package commands;

import utility.CommandManager;

public class HelpCommand extends AbstractCommand {
    private CommandManager commandManager;
    public HelpCommand() {
        super("help", "вывести справку по доступным командам");
    }

//    @Override
//    public String getUsage() {
//        return null;
//    }

    @Override
    public boolean execute(String argument) {
        System.out.println(commandManager.getCommands());
        return true;
    }
}
