package commands;

import exceptions.*;
import sourse.HumanBeing;
import utility.*;

import java.time.ZonedDateTime;

/**
 * Команда 'add_if_max'. Добавляет новый элемент в коллекцию, если он больше самого большого.
 */

public class AddElementIfMaxCommand extends AbstractCommand {
    private CollectionManager collectionManager;
    private HumanAsker humanAsker;

    public AddElementIfMaxCommand(CollectionManager collectionManager, HumanAsker humanAsker) {
        super("add_if_max {element}", "добавить новый элемент, если его значение больше, чем у наибольшего");
        this.collectionManager = collectionManager;
        this.humanAsker = humanAsker;
    }

    /**
     * Выполнение команды.
     *
     * @return Статус выхода команды.
     */

    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfElementsException();
            HumanBeing humanToAdd = new HumanBeing(
                    collectionManager.generateNextId(),
                    humanAsker.askName(),
                    humanAsker.askCoordinates(),
                    ZonedDateTime.now(),
                    humanAsker.askRealHero(),
                    humanAsker.askHasToothPick(),
                    humanAsker.askImpactSpeed(),
                    humanAsker.askSoundtrackName(),
                    humanAsker.askMinutesOfWaiting(),
                    humanAsker.askWeaponType(),
                    humanAsker.askCar()

            );
            if (collectionManager.collectionSize() == 0 || collectionManager.getMax().getImpactSpeed() < humanToAdd.getImpactSpeed()) {
                collectionManager.addMaxToCollection(humanToAdd);
                Console.println("Человек успешно добавлен!");
                return true;
            } else Console.printerror("Значение меньше, чем значение наибольшего человека!");
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Использование: '" + getName() + "'");
        } catch (IncorrectInputInScriptException exception) {
        }
        return false;
    }
}