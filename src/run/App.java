package run;

import commands.*;
import utility.*;

import java.util.Scanner;

public class App {

    public static final String PS1 = "$ ";
    public static final String PS2 = "> ";

    public static void main(String[] args) {
        try (Scanner userScanner = new Scanner(System.in)) {
            final String envVariable = "LABA";

            HumanAsker humanAsker = new HumanAsker(userScanner);
            FileManager fileManager = new FileManager();
            CollectionManager collectionManager = new CollectionManager(fileManager);

            CommandManager commandManager = new CommandManager(
                    new HelpCommand(),
                    new InfoCommand(collectionManager),
                    new ShowCommand(collectionManager),
                    new AddCommand(collectionManager, humanAsker),
                    new UpdateElementCommand(collectionManager, humanAsker),
                    new RemoveElementByIDCommand(collectionManager),
                    new ClearCommand(collectionManager),
                    new SaveCommand(collectionManager),
                    new ExecuteScriptCommand(),
                    new ExitCommand(),
                    new InsertElementAtIndexCommand(),
                    new AddElementIfMaxCommand(collectionManager, humanAsker),
                    new RemoveGreaterCommand(collectionManager, humanAsker),
                    new RemoveAllByWeaponTypeCommand(),
                    //TODO
                    new AverageOfMinutesOfWaitingCommand(collectionManager),
                    new FilterStartsWithNameCommand(collectionManager)
            );

            Console console = new Console(commandManager, userScanner, humanAsker);

            console.interactiveMode();
        }
    }

}
