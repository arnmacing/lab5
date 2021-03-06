package commands;

import exceptions.WrongAmountOfElementsException;
import utility.CollectionManager;
import utility.Console;
import utility.FileManager;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Команда 'info'. Вывод информации о коллекции
 */

public class InfoCommand extends AbstractCommand {
    private CollectionManager collectionManager;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("eee, MMM dd. yyyy.\nHH:mm:ss a - zzzz");

    public InfoCommand(CollectionManager collectionManager) {
        super("info", "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
        this.collectionManager = collectionManager;
    }

    /**
     * Выполнение команды.
     *
     * @return Статус выхода из команды.
     */

    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfElementsException();
            ZonedDateTime lastInitTime = collectionManager.getLastInitTime();
            String lastInitTimeString = (lastInitTime == null) ? "в данной сессии инициализации еще не происходило" :
                    lastInitTime.toLocalDate() + " " + lastInitTime.toLocalTime();

            ZonedDateTime lastSaveTime = collectionManager.getLastSaveTime();
            String lastSaveTimeString = (lastSaveTime == null) ? "в данной сессии сохранения еще не происходило" :
                    lastSaveTime.toLocalDate() + " " + lastSaveTime.toLocalTime();

            Console.println("Сведения о коллекции:");
            Console.println(" Тип: " + collectionManager.collectionType());
            Console.println(" Количество элементов: " + collectionManager.collectionSize());
            Console.println(" Дата последнего сохранения: " + lastSaveTimeString);
            Console.println(" Дата последней инициализации: " + lastInitTimeString);
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Использование: '" + getName() + "'");
        }
        return false;
    }
}
