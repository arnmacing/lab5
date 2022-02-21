package commands;

import sourse.HumanBeing;
import utility.CollectionManager;

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
        ArrayList<HumanBeing> arrayColection = collectionManager.getCollection();
        for (HumanBeing human : arrayColection) {
            if (human.getName().startsWith(argument)) {
                collectionManager.removeFromCollection(human);
                collectionManager.saveCollection();
            }
        }
        return true;
    }
}