package commands;

import utility.CollectionManager;

public class RemoveAllByWeaponTypeCommand extends AbstractCommand {
    private CollectionManager collectionManager;

    public  RemoveAllByWeaponTypeCommand(CollectionManager collectionManager) {
        super("remove_all_by_weapon_type weaponType", "удалить из коллекции все элементы, значение поля weaponType которого эквивалентно заданному");
        this.collectionManager = collectionManager;
    }

}
