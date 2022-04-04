package commands;

import exceptions.CollectionIsEmptyException;
import exceptions.WrongAmountOfElementsException;
import sourse.HumanBeing;
import utility.CollectionManager;
import utility.Console;

import java.util.ArrayList;
import java.util.List;


/**
 * Команда 'remove_starts_with_name name'. Удаляет элементы, значение поля name которых начинается с заданной подстроки.
 */
public class RemoveStartsWithNameCommand extends AbstractCommand {
    private CollectionManager collectionManager;

    public RemoveStartsWithNameCommand(CollectionManager collectionManager) {
        super("remove_starts_with_name name", "Удалить элементы, значение поля name которых начинается с заданной подстроки");
        this.collectionManager = collectionManager;
    }


    /**
     * Выполнение команды.
     *
     * @return Статус выхода из команды.
     */

    @Override
    public boolean execute(String argument) {
        boolean isDeleted = false;
        try {
            if (argument.isEmpty()) throw new WrongAmountOfElementsException();
            if (collectionManager.collectionSize() == 0) throw new CollectionIsEmptyException();
            List<HumanBeing> arrayColection = collectionManager.getCollection();
            for (HumanBeing human : arrayColection) {
                if (human.getName().startsWith(argument)) {
                    collectionManager.removeFromCollection(human);
                    isDeleted = true;
                    collectionManager.saveCollection();
                }
            }
            if (isDeleted) {
                Console.println("Удаление прошло успешно!");
            } else Console.println("В коллекции нет такого человека!");
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Использование: '" + getName() + "'");
        } catch (CollectionIsEmptyException exception) {
            Console.printerror("Коллекция пуста!");
        } catch (IllegalArgumentException exception) {
            Console.printerror("Такого имени нет в списке!");
        }
        return false;
    }
}
