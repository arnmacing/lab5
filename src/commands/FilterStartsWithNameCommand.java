package commands;

import utility.CollectionManager;


/**
 * Команда 'filter_starts_with_name name'. Выводит элементы, значение поля name которых начинается с заданной подстроки.
 */

//TODO filter starts with name command
public class FilterStartsWithNameCommand extends AbstractCommand {
    public FilterStartsWithNameCommand(CollectionManager collectionManager) {
        super("filter_starts_with_name name", "вывести элементы, значение поля name которых начинается с заданной подстроки");

    }


        /**
         * Выполнение команды.
         * @return Статус выхода из команды.
         * @param argument
         */

        @Override
        public boolean execute (String argument){
            return true;

    }
}