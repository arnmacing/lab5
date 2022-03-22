package commands;

import java.time.ZonedDateTime;

import sourse.HumanBeing;
import exceptions.*;
import utility.*;

/**
 * Command 'remove_greater'. Удаляет элементы, размер которых превышает введенный пользователем.
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
     * Выполняет команду.
     *
     * @return Статус выхода команды.
     */

    @Override
    public boolean execute(String argument) {
        try {
            if (argument.isEmpty()) throw new WrongAmountOfElementsException();
            if (collectionManager.collectionSize() == 0) throw new CollectionIsEmptyException();
            HumanBeing humanToFind = new HumanBeing(
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
            HumanBeing humanFromCollection = collectionManager.getByValue(humanToFind);
            if (humanFromCollection == null) throw new HumanNotFoundException();
            collectionManager.removeGreater(humanFromCollection);
            Console.println("Удаление прошло успешно!");
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Использование: '" + getName() + "'");
        } catch (CollectionIsEmptyException exception) {
            Console.printerror("Коллекция пуста!");
        } catch (HumanNotFoundException exception) {
            Console.printerror("Человека с такими характеристиками в коллекции нет!");
        } catch (IncorrectInputInScriptException exception) {
            Console.printerror("Неверный ввод в скрипте");
        }
        return false;
    }
}