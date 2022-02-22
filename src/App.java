import commands.*;
import dao.DAO;
import utility.*;

import java.util.Scanner;

public class App {

    private final DAO dao;

    public App(DAO dao) {
        this.dao = dao;
    }

    public static void main(String[] args) {
        try (Scanner userScanner = new Scanner(System.in)) {
            // System.getenv("LABA")
            final String envVariable = "LABA";

            HumanAsker humanAsker = new HumanAsker(userScanner);
            FileManager fileManager = new FileManager(envVariable);
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
                    new InsertElementAtIndexCommand(collectionManager, humanAsker),
                    new AddElementIfMaxCommand(collectionManager, humanAsker),
                    new RemoveGreaterCommand(collectionManager, humanAsker),
                    new RemoveAllByWeaponTypeCommand(collectionManager),
                    new AverageOfMinutesCommand(collectionManager),
                    new FilterStartsWithNameCommand(collectionManager)
            );

            Console console = new Console(commandManager, userScanner, humanAsker);

            console.interactiveMode();
        }
    }

}