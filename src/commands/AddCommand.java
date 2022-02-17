package commands;

import utility.CollectionManager;
import utility.HumanAsker;

public class AddCommand {
    public AddCommand(CollectionManager collectionManager, HumanAsker humanAsker) {

    }

    @Override
    public boolean execute(String stringArgument, Object objectArgument) {
        try {
            if (!stringArgument.isEmpty() || objectArgument == null) throw new WrongAmountOfElementsException();
            HumanRaw humanRaw = (HumanRaw) objectArgument;
            collectionManager.addToCollection(new SpaceMarine(
                    collectionManager.generateNextId(),
                    marineRaw.getName(),
                    marineRaw.getCoordinates(),
                    LocalDateTime.now(),
                    marineRaw.getHealth(),
                    marineRaw.getCategory(),
                    marineRaw.getWeaponType(),
                    marineRaw.getMeleeWeapon(),
                    marineRaw.getChapter()
            ));
            ResponseOutputer.appendln("Солдат успешно добавлен!");
            return true;
        } catch (WrongAmountOfElementsException exception) {
            ResponseOutputer.appendln("Использование: '" + getName() + " " + getUsage() + "'");
        } catch (ClassCastException exception) {
            ResponseOutputer.appenderror("Переданный клиентом объект неверен!");
        }
        return false;
    }
}

