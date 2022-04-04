package commands;


import exceptions.*;

import sourse.HumanBeing;

import sourse.WeaponType;
import utility.CollectionManager;
import utility.Console;

import java.util.ArrayList;
import java.util.List;

/**
 * Команда 'remove_all_by_weapon_type weaponType'. Удаляет из коллекции все элементы, значение поля weaponType которого эквивалентно заданному.
 */

public class RemoveAllByWeaponTypeCommand extends AbstractCommand {
    private CollectionManager collectionManager;

    public  RemoveAllByWeaponTypeCommand(CollectionManager collectionManager) {
        super("remove_all_by_weapon_type weaponType", "удалить из коллекции все элементы, значение поля weaponType которого эквивалентно заданному");
        this.collectionManager = collectionManager;
    }
//todo remove all by weapon type command

    /**
     * Выполняет команду.
     * @return Статус выхода команды.
     */

    @Override
    public boolean execute(String argument) {


        List<HumanBeing> collection = collectionManager.getCollection(); // пол

        for (HumanBeing human : collection) {
            if (human.getWeaponType() == WeaponType.valueOf(argument)) {
                collectionManager.removeFromCollection(human);
                collectionManager.saveCollection();
            }
            //if (human.getId() == Integer.parseInt(argument)) collectionManager.removeFromCollection(human);
        }

        try {
            if (argument.isEmpty()) throw new WrongAmountOfElementsException();
            if (collectionManager.collectionSize() == 0) {
                throw new CollectionIsEmptyException();
            } else
                Console.println("В коллекции нет человека с выбранным типом оружия!");
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Использование: '" + getName() + "'");
        } catch (CollectionIsEmptyException e) {
            Console.printerror("Коллекция пуста!");
        } catch (IllegalArgumentException e) {
            Console.printerror("Оружия нет в списке!");
            Console.println("Список оружия - " + WeaponType.nameList());
        }
        return false;

    }
}
