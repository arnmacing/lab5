package commands;

import exceptions.*;
import sourse.*;
import utility.*;
import java.time.ZonedDateTime;

/**
 * Команда "обновить" обновляет информацию о человеке.
 */

public class UpdateElementCommand extends AbstractCommand {
    private CollectionManager collectionManager;
    private HumanAsker humanAsker;

    public UpdateElementCommand(CollectionManager collectionManager, HumanAsker humanAsker) {
        super("update <ID> {element}", "обновить значение элемента коллекции по ID");
        this.collectionManager = collectionManager;
        this.humanAsker = humanAsker;
    }


    /**
     * Выполнение команды.
     * @return Статус выхода команды.
     */

    @Override
    public boolean execute(String argument) {
        try {
            if (argument.isEmpty()) throw new WrongAmountOfElementsException(); // ошибка количества элементов
            if (collectionManager.collectionSize() == 0) throw new CollectionIsEmptyException(); // ошибка пустой коллекции

            int id = Integer.parseInt(argument);

            HumanBeing oldHuman = collectionManager.getById(id);
            if (oldHuman == null) throw new HumanNotFoundException(); // человек не найден


            String name = oldHuman.getName();
            Coordinates coordinates = oldHuman.getCoordinates();
            ZonedDateTime creationDate = oldHuman.getCreationDate();
            boolean realHero = oldHuman.checkRealHero();
            Boolean hasToothpick = oldHuman.checkHasToothpick();
            Integer impactSpeed = oldHuman.getImpactSpeed();
            String soundtrackName = oldHuman.getSoundtrackName();
            float minutesOfWaiting = oldHuman.getMinutesOfWaiting();
            WeaponType weaponType = oldHuman.getWeaponType();
            Car car = oldHuman.getCar();


            collectionManager.removeFromCollection(oldHuman);

            if (humanAsker.askQuestion("Хотите изменить имя человека?")) name = humanAsker.askName();
            if (humanAsker.askQuestion("Хотите изменить координаты человека?")) coordinates = humanAsker.askCoordinates();
            if (humanAsker.askQuestion("Хотите изменить статус человека?")) realHero = humanAsker.askRealHero();
            if (humanAsker.askQuestion("Хотите изменить наличие зубочистки?")) hasToothpick = humanAsker.askHasToothPick();
            if (humanAsker.askQuestion("Хотите изменить оружие?")) weaponType = humanAsker.askWeaponType();
            if (humanAsker.askQuestion("Хотите изменить скорость удара?")) impactSpeed = humanAsker.askImpactSpeed();
            if (humanAsker.askQuestion("Хотите изменить саундтрек?")) soundtrackName = humanAsker.askSoundtrackName();
            if (humanAsker.askQuestion("Хотите изменить количество минут ожидания?")) minutesOfWaiting = humanAsker.askMinutesOfWaiting();
            if (humanAsker.askQuestion("Хотите изменить машину?")) car = humanAsker.askCar();

            collectionManager.addToCollection(new HumanBeing(
            id,
            name,
            coordinates,
            creationDate,
            realHero,
            hasToothpick,
            impactSpeed,
            soundtrackName,
            minutesOfWaiting,
            weaponType,
            car
            ));
            Console.println("Человек успешно изменен!");
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Использование: '" + getName() + "'");
        } catch (CollectionIsEmptyException exception) {
            Console.printerror("Коллекция пуста!");
        } catch (NumberFormatException exception) {
            Console.printerror("ID должен быть представлен числом!");
        } catch (HumanNotFoundException exception) {
            Console.printerror("Солдата с таким ID в коллекции нет!");
        } catch (IncorrectInputInScriptException exception) {}
        return false;
    }
}