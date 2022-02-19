package commands;

import java.time.ZonedDateTime;

import sourse.HumanBeing;
import exceptions.CollectionIsEmptyException;
import exceptions.IncorrectInputInScriptException;
import exceptions.HumanNotFoundException;
import exceptions.WrongAmountOfElementsException;
import utility.CollectionManager;
import utility.Console;
import utility.HumanAsker;

/**
 * Command 'remove_greater'. Removes elements greater than user entered.
 */
public class RemoveGreaterCommand extends AbstractCommand {
    private CollectionManager collectionManager;
    private HumanAsker humanAsker;

    public RemoveGreaterCommand(CollectionManager collectionManager, HumanAsker humanAsker) {
        super("remove_greater {element}", "удалить из коллекции все элементы, превышающие заданный");
        this.collectionManager = collectionManager;
        this.humanAsker = humanAsker;
    }

    /**
     * Executes the command.
     * @return Command exit status.
     */
    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfElementsException();
            if (collectionManager.collectionSize() == 0) throw new CollectionIsEmptyException();
            HumanBeing humanToFind = new HumanBeing(
                    //TODO generate next id
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
            );
            //TODO get by value
            HumanBeing humanFromCollection = collectionManager.getByValue(humanToFind);
            if (humanFromCollection == null) throw new HumanNotFoundException();
            //TODO remove greater
            collectionManager.removeGreater(humanFromCollection);
            //TODO text
            Console.println("а что писать ну.. хуй");
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Использование: '" + getName() + "'");
        } catch (CollectionIsEmptyException exception) {
            Console.printerror("Коллекция пуста!");
        } catch (HumanNotFoundException exception) {
            Console.printerror("Человека с такими характеристиками в коллекции нет!");
        } catch (IncorrectInputInScriptException exception) {}
        return false;
    }
}