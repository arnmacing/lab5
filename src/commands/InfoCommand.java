package commands;

import utility.CollectionManager;
import utility.FileManager;

public class InfoCommand extends AbstractCommand {
    private CollectionManager collectionManager;
    public InfoCommand(CollectionManager collectionManager){
        super("info","вывести справку по коллекции" );
        this.collectionManager = this.collectionManager;
    }

//    @Override
//    public String getUsage() {
//        return null;
//    }

    @Override
    public boolean execute(String argument) {
        System.out.println ("Инициализация: " + FileManager.lastInit);
        System.out.println("Тип коллекции: " + collectionManager.collectionType());
        System.out.println ("Количество элементов в коллекции: " + FileManager.humanCollection.size());
        return true;
    }
}
