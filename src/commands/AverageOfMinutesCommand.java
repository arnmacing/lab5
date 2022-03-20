package commands;

import exceptions.CollectionIsEmptyException;
import exceptions.WrongAmountOfElementsException;
import utility.CollectionManager;
import utility.Console;

/**
 * Команда 'average_of_minutes_of_waiting'. Выводит среднее время ожидания.
 */

public class AverageOfMinutesCommand extends AbstractCommand {
    private CollectionManager collectionManager;

    public AverageOfMinutesCommand(CollectionManager collectionManager) {
        super("Average of minutes", "вывести среднее значение поля minutesOfWaiting для всех элементов коллекции");
        this.collectionManager = collectionManager;
    }

    /**
     * Выполнение команды.
     *
     * @param argument
     * @return Статус выхода команды.
     */

    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfElementsException();
            double averageOfMin = collectionManager.getAverageOfMin();
            if (averageOfMin == 0) throw new CollectionIsEmptyException();
            Console.println("Среднее время ожидания: " + averageOfMin);
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Использование: '" + getName() + "'");
        } catch (CollectionIsEmptyException exception) {
            Console.printerror("Коллекция пуста!");
        }
        return false;
    }
}
