package commands;

import java.time.ZonedDateTime;

import sourse.HumanBeing;
import exceptions.IncorrectInputInScriptException;
import exceptions.WrongAmountOfElementsException;
import utility.CollectionManager;
import utility.Console;
import utility.HumanAsker;

/**
 * Команда 'add'. Добавляет новый элемент в коллекцию.
 */

public class AddCommand extends AbstractCommand {
    private CollectionManager collectionManager;
    private HumanAsker humanAsker;

    public AddCommand(CollectionManager collectionManager, HumanAsker humanAsker) {
        super("add {element}", "добавить новый элемент в коллекцию");
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
            collectionManager.addToCollection(new HumanBeing(
                    Math.toIntExact(collectionManager.generateNextId()),
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
            ));
            Console.println("Человек успешно добавлен!");
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Использование: '" + getName() + "'");
        } catch (IncorrectInputInScriptException exception) {
        }
        return false;
    }
}