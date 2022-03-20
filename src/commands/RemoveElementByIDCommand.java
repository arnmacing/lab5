package commands;

import exceptions.*;
import sourse.HumanBeing;
import utility.*;

/**
 * Команда 'remove_by_id'. Удаляет элемент по его ID.
 */

public class RemoveElementByIDCommand extends AbstractCommand {
    private CollectionManager collectionManager;

    public RemoveElementByIDCommand(CollectionManager collectionManager) {
        super("remove_by_id <ID>", "удалить элемент из коллекции по ID");
        this.collectionManager = collectionManager;
    }

    /**
     * Выполняет команду.
     *
     * @return Статус выхода команды.
     */

    @Override
    public boolean execute(String argument) {
        try {
            if (argument.isEmpty()) throw new WrongAmountOfElementsException();
            if (collectionManager.collectionSize() == 0) throw new CollectionIsEmptyException();
            Integer id = Integer.parseInt(argument);
            HumanBeing humanToRemove = collectionManager.getById(id);
            if (humanToRemove == null) throw new HumanNotFoundException();
            collectionManager.removeFromCollection(humanToRemove);
            Console.println("Человек успешно удален!");
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Использование: '" + getName() + "'");
        } catch (CollectionIsEmptyException exception) {
            Console.printerror("Коллекция пуста!");
        } catch (NumberFormatException exception) {
            Console.printerror("ID должен быть представлен числом!");
        } catch (HumanNotFoundException exception) {
            Console.printerror("Человека с таким ID в коллекции нет!");
        }
        return false;
    }
}
