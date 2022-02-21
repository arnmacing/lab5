package commands;

import utility.CollectionManager;

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
        return false;
    }
}
