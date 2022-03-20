package utility;

import sourse.HumanBeing;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import dao.DAOHumanBeign;


public class CollectionManager<T> {
    DAOHumanBeign human = new DAOHumanBeign();
    private ZonedDateTime lastInitTime;
    private ZonedDateTime lastSaveTime;
    private FileManager fileManager;
    private Collection<HumanBeing> humanCollection;

    public CollectionManager(FileManager fileManager) {
        this.human = null;
        this.lastInitTime = null;
        this.lastSaveTime = null;
        this.fileManager = fileManager;
        loadCollection();
    }

    /**
     * Загружает коллекцию из файла.
     */
    private void loadCollection() {
        //humanCollection = fileManager.readCollection();
        lastInitTime = ZonedDateTime.now();
    }


    public HumanBeing getMax() {
        if (human.getAll().isEmpty()) {
            return null;
        }
        return Collections.max(human.getAll());
    }


    public HumanBeing getMin() {
        if (human.getAll().isEmpty()) {
            return null;
        }
        return Collections.min(human.getAll());
    }

    /**
     * @return Коллекция.
     */

    public ArrayList<HumanBeing> getCollection() {
        return (ArrayList<HumanBeing>) human.getAll();
    }

    /**
     * @return Время последней инициализации или null, если инициализации не было.
     */

    public ZonedDateTime getLastInitTime() {
        return lastInitTime;
    }

    /**
     * @return Время последнего сохранения или null, если сохранения не было.
     */

    public ZonedDateTime getLastSaveTime() {
        return lastSaveTime;
    }

    /**
     * @return Тип коллекции.
     */
    public String collectionType() {
        return human.getAll().getClass().getName();
    }

    /**
     * @return Размер коллекции.
     */
    public int collectionSize() {
        return human.getAll().size();
    }


    /**
     * @param id ID человека.
     * @return Человек по его ID или null, если человек не найден.
     */

    public HumanBeing getById(int id) {
        for (HumanBeing human : human.getAll()) {
            if (human.equals(id)) return human;
        }
        return null;
    }

    /**
     * @param humanToFind Найти человека, чья ценность будет найдена.
     * @return Человека по его значению или null, если человек не найден.
     */

    public HumanBeing getByValue(HumanBeing humanToFind) {
        for (HumanBeing human : human.getAll()) {
            if (human.equals(humanToFind)) return human;
        }
        return null;
    }

    /**
     * @return Первый элемент коллекции или null, если коллекция пуста.
     */

    public HumanBeing getFirst() {
        if (human.getAll().isEmpty()) return null;
        return human.getAll().get(0);
    }

    /**
     * @return Последний элемент коллекции или null, если коллекция пуста.
     */

    public HumanBeing getLast() {

        if (human.getAll().isEmpty()) return null;
        return human.getAll().get(human.getAll().size() - 1);
    }

    /**
     * Добавление нового человека в коллекцию.
     */

    public void addToCollection(HumanBeing human) {
        humanCollection.add(human);
    }

    /**
     * Удаление человека из коллекции.
     */

    public void removeFromCollection(int id) {
        human.delete(id);
    }


    /**
     * Очистка колекции.
     */

    public void clearCollection() {
        human.clear();
    }

    /**
     * Удаление людей, которых больше, чем выбранный.
     *
     * @param humanh Человек, с которым можно сравнить.
     */

    public void removeGreater(HumanBeing humanh) {
        Integer impactSpeed = humanh.getImpactSpeed();
        for (HumanBeing human1 : humanCollection) {
            if (human1.getImpactSpeed() > impactSpeed) {
                human.delete(human1.getId());
            }
        }
    }
    /**
     * Генерирует следующий идентификатор. Это будет (больший + 1).
     * @return Cледующий ID.
     */

    public int generateNextId() {
        if (humanCollection.isEmpty()) return 1;
        return Collections.max(humanCollection).getId() + 1;
    }


    /**
     * Сохраняет коллекцию в файл.
     */
    public void saveCollection() {
        fileManager.writeCollection(humanCollection);
        lastSaveTime = ZonedDateTime.now();
    }

    /**
     * @return Среднее значение поля minutesOfWaiting для всех элементов коллекции.
     */

    public double getAverageOfMin() {

        double averageOfMin = 0;
        int n = 0;
        for (HumanBeing humanh : humanCollection) {
            averageOfMin += humanh.getMinutesOfWaiting();
            n += 1;
        }
        return averageOfMin / n;
    }

//    /**
//     * Метод сортировки коллекции.
//     */
//
//    public void sortCollection(){
//        .sort(humanCollection);
//    }

    /**
     * Метод, чтобы получить коллекцию для пользователя.
     */

    public ArrayList<HumanBeing> getCollectionForUser() {
        human.sort();
        return (human.getAll());
    }
}

