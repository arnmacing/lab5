package commands;

import sourse.HumanBeing;
import utility.CollectionManager;
import utility.Console;
import utility.HumanAsker;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Command 'add_if_max'. Adds a new element to collection if it's more than the largest.
 */

public class AddElementIfMaxCommand extends AbstractCommand {
    private CollectionManager collectionManager;
    private HumanAsker humanAsker;
    private ArrayList<HumanBeing> humanCollection = new ArrayList<>();

    public AddElementIfMaxCommand (CollectionManager collectionManager, HumanAsker humanAsker)
    {
        super("add_if_max {element}", "добавить новый элемент, если его значение больше, чем у наибольшего");
        this.collectionManager = collectionManager;
        this.humanAsker = humanAsker;
    }

    /**
     * Выполнение команды.
     * @return Статус выхода команды.
     * @param argument
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
            if (collectionManager.collectionSize() == 0 ||  humanToAdd.) ) { // условие ???????
                collectionManager.addToCollection(humanToAdd);
                Console.println("Человек успешно добавлен!");
                return true;
            } else Console.printerror("Значение меньше, чем значение наибольшего человека!");
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Использование: '" + getName() + "'");
        } catch (IncorrectInputInScriptException exception) {}
        return false;
    }
}