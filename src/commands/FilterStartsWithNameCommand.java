package commands;

import exceptions.CollectionIsEmptyException;
import exceptions.WrongAmountOfElementsException;
import sourse.HumanBeing;
import sourse.WeaponType;
import utility.CollectionManager;
import utility.Console;

import java.util.ArrayList;


/**
 * Команда 'filter_starts_with_name name'. Выводит элементы, значение поля name которых начинается с заданной подстроки.
 */

//TODO filter starts with name command
public class FilterStartsWithNameCommand extends AbstractCommand {
    private CollectionManager collectionManager;

    public FilterStartsWithNameCommand(CollectionManager collectionManager) {
        super("filter_starts_with_name name", "вывести элементы, значение поля name которых начинается с заданной подстроки");
        this.collectionManager = collectionManager;
    }


    /**
     * Выполнение команды.
     * @return Статус выхода из команды.
     */

    @Override
    public boolean execute (String argument){
        try {
            if (argument.isEmpty()) throw new WrongAmountOfElementsException();
            if (collectionManager.collectionSize() == 0) throw new CollectionIsEmptyException();
            ArrayList<HumanBeing> arrayColection = collectionManager.getCollection();
            for (HumanBeing human : arrayColection) {
                if (human.getName().startsWith(argument)) {
                collectionManager.removeFromCollection(human);
                collectionManager.saveCollection();
                }
            return true;
        } else Console.println("В коллекции нет человека с выбранным типом оружия!");
    } catch (WrongAmountOfElementsException exception) {
        Console.println("Использование: '" + getName() + "'");
    } catch (CollectionIsEmptyException exception) {
        Console.printerror("Коллекция пуста!");
    } catch (IllegalArgumentException exception) {
        Console.printerror("Оружия нет в списке!");
        Console.println("Список оружия  - " + WeaponType.nameList());
    }
        return false;
}
}