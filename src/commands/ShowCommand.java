package commands;

import utility.CollectionManager;

public class ShowCommand extends AbstractCommand {
    private CollectionManager collectionManager;
    public ShowCommand(CollectionManager collectionManager) {
        super("show", "вывести все элементы коллекции");

    }

//    @Override
//    public String getUsage() {
//        return null;
//    }

    @Override
    public boolean execute(String argument) {
        System.out.println(collectionManager.getCollection());
        return false;
    }
}
