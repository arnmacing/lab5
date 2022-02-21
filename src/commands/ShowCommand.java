package commands;

import utility.CollectionManager;

/**
 * Команда 'show'. Выводит все элементы коллекции в строковом представлении.
 */
public class ShowCommand extends AbstractCommand {
    private CollectionManager collectionManager;
    public ShowCommand(CollectionManager collectionManager) {
        super("show", "вывести все элементы коллекции");

    }

    /**
     * Выполняет команду.
     * @return Статус выхода команды.
     */

    @Override
    public boolean execute(String argument) {
        System.out.println(collectionManager.getCollection());
        return false;
    }
}
