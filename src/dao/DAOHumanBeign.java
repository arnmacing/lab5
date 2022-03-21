package dao;

import sourse.*;
import utility.FileManager;

import javax.json.*;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;


/**
 * Класс, который имплементируется от dao.DAO. В нём мы реализуем методы для работы с коллекцией и инициализируем саму коллекцию
 */


public class DAOHumanBeign implements DAO {
    private ZonedDateTime initDateTime;
    private static int availableId = 1;
    protected ArrayList<HumanBeing> humanCollection = new ArrayList<>();


    /**
     * Метод добавления элемента в коллекцию
     */

    @Override
    public int create(HumanBeing human) {
        humanCollection.add(new HumanBeing(availableId, human.getName(), human.getCoordinates(), human.getCreationDate(),
                human.checkRealHero(), human.checkHasToothpick(), human.getImpactSpeed(), human.getSoundtrackName(),
                human.getMinutesOfWaiting(), human.getWeaponType(), human.getCar()));
        return availableId++;
    }


    /**
     * Метод обновления элемента в коллекции по его id
     */

    @Override
    public void update(HumanBeing human) {
        HumanBeing existedHuman = get(human.getId());

        if (existedHuman != null) {
            existedHuman.setName(human.getName());
            existedHuman.setCoordinates(human.getCoordinates());
            existedHuman.setCreationDate(human.getCreationDate());
            existedHuman.setRealHero(human.checkRealHero());
            existedHuman.setHasToothpick(human.checkHasToothpick());
            existedHuman.setImpactSpeed(human.getImpactSpeed());
            existedHuman.setSoundtrackName(human.getSoundtrackName());
            existedHuman.setMinutesOfWaiting(human.getMinutesOfWaiting());
            existedHuman.setWeaponType(human.getWeaponType());
            existedHuman.setCar(human.getCar());
        }
    }

    /**
     * Метод удаления элемента из коллекции по его id
     *
     * @param id - id элемента, который пользователь хочет удалить
     */

    @Override
    public void delete(int id) {
        HumanBeing existedHuman = get(id);

        if (existedHuman != null) {
            humanCollection.remove(existedHuman);
        }
    }

    /**
     * Метод получения элемента из коллекции по его id
     *
     * @param id - id элемента, который пользователь хочет получить
     * @return dragon - элемент коллекции
     */

    @Override
    public HumanBeing get(int id) {

        for (HumanBeing human : humanCollection) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }

    /**
     * Метод получения всей коллекции
     *
     * @return outputCollection - копия коллекции
     */

    @Override
    public ArrayList<HumanBeing> getAll() {
        ArrayList<HumanBeing> outputCollection = new ArrayList<>();
        outputCollection.addAll(humanCollection);
        Collections.sort(outputCollection);
        return outputCollection;
    }

    /**
     * Метод очистки всей коллекции
     */

    @Override
    public void clear() {
        humanCollection.clear();
    }

    /**
     * Метод для сортировки коллекции
     */

    @Override
    public void sort() {
        Collections.sort(humanCollection);
    }

    public DAOHumanBeign() {
        initDateTime = ZonedDateTime.now();
    }

    public ZonedDateTime getInitDateTime() {
        return initDateTime;
    }

    /**
     * Метод для загрузки коллекции
     */

    public void loadCollection(FileManager fileManager) {
        humanCollection = fileManager.readCollection();
    }

}