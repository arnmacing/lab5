package commands;

import exceptions.CollectionIsEmptyException;
import exceptions.WrongAmountOfElementsException;
import sourse.WeaponType;
import utility.CollectionManager;
import utility.Console;

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
        try {
            if (argument.isEmpty()) throw new WrongAmountOfElementsException();
            if (collectionManager.collectionSize() == 0) throw new CollectionIsEmptyException();
            WeaponType weaponType = WeaponType.valueOf(argument.toUpperCase());


                return true;
            } else Console.println("В коллекции нет человека с выбранным типом оружия!");
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
