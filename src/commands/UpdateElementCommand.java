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

    @Override
    public String getUsage() {
        return null;
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

            Long id = Long.parseLong(argument);
            HumanBeing humanBeing = collectionManager.getById(id);
            if (humanBeing == null) throw new HumanNotFoundException(); // человек не найден

            String name = humanBeing.setName();
            Coordinates coordinates = humanBeing.setCoordinates();
            LocalDateTime creationDate = humanBeing.setCreationDate();
            boolean realHero = humanBeing.setRealHero();
            Boolean hasToothpick = humanBeing.setHasToothpick();
            Integer impactSpeed = humanBeing.setImpactSpeed();
            String soundtrackName = humanBeing.setSoundtrackName();
            float minutesOfWaiting = humanBeing.setMinutesOfWaiting();
            WeaponType weaponType = humanBeing.getWeaponType();
            Car car = humanBeing.getCar();


            collectionManager.removeFromCollection(humanBeing);

            if (humanAsker.askQuestion("Хотите изменить имя солдата?")) name = humanAsker.askName();
            if (humanAsker.askQuestion("Хотите изменить координаты солдата?")) coordinates = humanAsker.askCoordinates();
            if (humanAsker.askQuestion("Хотите изменить здоровье солдата?")) health = marineAsker.askHealth();
            if (humanAsker.askQuestion("Хотите изменить категорию солдата?")) category = marineAsker.askCategory();
            if (humanAsker.askQuestion("Хотите изменить оружие дальнего боя солдата?")) weaponType = marineAsker.askWeaponType();
            if (humanAsker.askQuestion("Хотите изменить оружие ближнего боя солдата?")) meleeWeapon = marineAsker.askMeleeWeapon();
            if (humanAsker.askQuestion("Хотите изменить орден солдата?")) chapter = marineAsker.askChapter();

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
            Console.println("Солдат успешно изменен!");
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