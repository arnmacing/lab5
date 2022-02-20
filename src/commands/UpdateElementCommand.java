package commands;

import sourse.Car;
import sourse.Coordinates;
import sourse.HumanBeing;
import sourse.WeaponType;
import utility.CollectionManager;
import utility.Console;
import utility.HumanAsker;

import java.time.LocalDateTime;

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

//    @Override
//    public String getUsage() {
//        return null;
//    }

    /**
     * Выполнение команды.
     * @return Статус выхода команды.
     */

    @Override
    public boolean execute(String argument) {
        try {
            if (argument.isEmpty()) throw new WrongAmountOfElementsException(); // ошибка количества элементов
            if (collectionManager.collectionSize() == 0) throw new CollectionIsEmptyException(); // ошибка пустой коллекц
          
            int id = Integer.parseInt(argument);
            HumanBeing humanBeing = collectionManager.getById(Math.toIntExact(id));
            if (humanBeing == null) throw new HumanNotFoundException(); // человек не найден

            String name = oldHuman.setName();
            Coordinates coordinates = oldHuman.setCoordinates();
            LocalDateTime creationDate = oldHuman.setCreationDate();
            boolean realHero = oldHuman.setRealHero();
            Boolean hasToothpick = oldHuman.setHasToothpick();
            Integer impactSpeed = oldHuman.setImpactSpeed();
            String soundtrackName = oldHuman.setSoundtrackName();
            float minutesOfWaiting = oldHuman.setMinutesOfWaiting();
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
        } catch (MarineNotFoundException exception) {
            Console.printerror("Солдата с таким ID в коллекции нет!");
        } catch (IncorrectInputInScriptException exception) {}
        return false;
    }
}