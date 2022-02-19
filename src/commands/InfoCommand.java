package commands;

import utility.CollectionManager;
import utility.Console;
import utility.FileManager;

public class InfoCommand extends AbstractCommand {
    private CollectionManager collectionManager;
    public InfoCommand(CollectionManager collectionManager){
        super("info","вывести справку по коллекции" );
        this.collectionManager = this.collectionManager;
    }

    @Override
    public boolean execute(String argument) {
        Console.println ("Инициализация: " + FileManager.lastInit);
        Console.println("Тип коллекции: " + collectionManager.collectionType());
        Console.println ("Количество элементов в коллекции: " + FileManager.humanCollection.size());
        return true;
    }
}
