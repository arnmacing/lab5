package commands;

import utility.CollectionManager;
import utility.Console;
import utility.FileManager;

/**
 * Команда 'info'. Вывод информации о коллекции
 */

public class InfoCommand extends AbstractCommand {
    private CollectionManager collectionManager;
    public InfoCommand(CollectionManager collectionManager){
        super("info","вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)" );
        this.collectionManager = this.collectionManager;
    }

    /**
     * Выполнение команды.
     * @return Статус выхода из команды.
     * @param argument
     */

    @Override
    public boolean execute(String argument) {
        Console.println ("Инициализация: " + FileManager.lastInit);
        Console.println("Тип коллекции: " + collectionManager.collectionType());
        Console.println ("Количество элементов в коллекции: " + FileManager.humanCollection.size());
        return true;
    }
}
