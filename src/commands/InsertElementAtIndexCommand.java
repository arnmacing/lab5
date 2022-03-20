package commands;

import exceptions.*;
import sourse.HumanBeing;
import utility.*;

import java.time.ZonedDateTime;

/**
 * Команда 'insert_at index {element}'. Добавление нового элемента в заданную позицию.
 */

public class InsertElementAtIndexCommand extends AbstractCommand {
    private CollectionManager collectionManager;
    private HumanAsker humanAsker;

    public InsertElementAtIndexCommand(CollectionManager collectionManager, HumanAsker humanAsker) {
        super("insert_at_index {element}", "добавить новый элемент в заданную позицию");
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
            collectionManager.getCollection().remove(Integer.parseInt(argument));

            HumanBeing humanToInsert = new HumanBeing(
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

            collectionManager.getCollection().set(Integer.parseInt(argument), humanToInsert);
            collectionManager.saveCollection();
            Console.println("Человек успешно добавлен!");
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Использование: '" + getName() + "'");
        } catch (NumberFormatException | IncorrectInputInScriptException exception) {
            Console.printerror("Индекс должен быть представлен числом!");
        }
        return false;
    }

}

