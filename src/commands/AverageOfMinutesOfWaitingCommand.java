package commands;

import utility.CollectionManager;
import utility.Console;

public class AverageofMinutesCommand extends AbstractCommand {
    private CollectionManager collectionManager;

    public AverageofMinutesCommand(CollectionManager collectionManager) {
        super("Average of minutes", "вывести среднее значение поля minutesOfWaiting для всех элементов коллекции");
        this.collectionManager = collectionManager;
    }

    /**
     * Executes the command.
     *
     * @return Command exit status.
     */
    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfElementsException();
            double averageOfMin = collectionManager.getAverageOfMin();
            if (averageOfMin == 0) throw new CollectionIsEmptyException();
            Console.println("Сумма здоровья всех солдат: " + averageOfMin);
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Использование: '" + getName() + "'");
        } catch (CollectionIsEmptyException exception) {
            Console.printerror("Коллекция пуста!");
        }
        return false;
    }
}
