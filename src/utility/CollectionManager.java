package utility;

import dao.DAOHumanBeign;
import sourse.HumanBeing;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;

public class CollectionManager<T> {
    DAOHumanBeign dao = new DAOHumanBeign();
    private ZonedDateTime lastInitTime;
    private ZonedDateTime lastSaveTime;
    private FileManager fileManager;

    public CollectionManager(FileManager fileManager) {
        this.lastInitTime = null;
        this.lastSaveTime = null;
        this.fileManager = fileManager;
        loadCollection();
    }
    /**
     * Загружает коллекцию из файла.
     */
    private void loadCollection() {
        dao.loadCollection(fileManager);
        lastInitTime = ZonedDateTime.now();
    }

    public HumanBeing getMax() {
        if (dao.getAll().isEmpty()) {
            return null;
        }
        return Collections.max(dao.getAll());
    }

    public HumanBeing getMin() {
        if (dao.getAll().isEmpty()) {
            return null;
        }
        return Collections.min(dao.getAll());
    }
    /**
     * @return Коллекция.
     */
    public ArrayList<HumanBeing> getCollection() {
        return dao.getAll();
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
        return dao.getAll().getClass().getName();
    }
    /**
     * @return Размер коллекции.
     */
    public int collectionSize() {
        return dao.getAll().size();
    }
    /**
     * @param id ID человека.
     * @return Человек по его ID или null, если человек не найден.
     */
    public HumanBeing getById(int id) {
        for (HumanBeing human : dao.getAll()) {
            if (human.getId() == id) return human;
        }
        return null;
    }
    /**
     * @param humanToFind Найти человека, чья ценность будет найдена.
     * @return Человека по его значению или null, если человек не найден.
     */
    public HumanBeing getByValue(HumanBeing humanToFind) {
        for (HumanBeing human : dao.getAll()) {
            if (human.equals(humanToFind)) return human;
        }
        return null;
    }
    /**
     * @return Первый элемент коллекции или null, если коллекция пуста.
     */
    public HumanBeing getFirst() {
        if (dao.getAll().isEmpty()) return null;
        return dao.getAll().get(0);
    }
    /**
     * @return Последний элемент коллекции или null, если коллекция пуста.
     */

    public HumanBeing getLast() {
        if (dao.getAll().isEmpty()) return null;
        return dao.getAll().get(dao.getAll().size() - 1);
    }

    /**
     * Добавление нового человека в коллекцию.
     */
    public void addToCollection(HumanBeing human) {
        dao.create(human);
    }
    /**
     * Удаление человека из коллекции.
     */
    public void removeFromCollection(HumanBeing human) {
        dao.delete(human.getId());
    }
    /**
     * Очистка колекции.
     */
    public void clearCollection() {
        dao.clear();
    }

    /**
     * Удаление людей, которых больше, чем выбранный.
     *
     * @param human Человек, с которым можно сравнить.
     */

    public void removeGreater(HumanBeing human) {
        Integer impactSpeed = human.getImpactSpeed();
        for (HumanBeing human1 : dao.getAll()) {
            if (human1.getImpactSpeed() > impactSpeed) {
                dao.delete(human1.getId());
            }
        }
    }

    /**
     * Генерирует следующий идентификатор. Это будет (больший + 1).
     *
     * @return Cледующий ID.
     */


    public int generateNextId() {
        if (dao.getAll().isEmpty()) return 1;
        return Collections.max(dao.getAll()).getId() + 1;
    }
    /**
     * Сохраняет коллекцию в файл.
     */
    public void saveCollection() {
        fileManager.writeCollection(dao.getAll());
        lastSaveTime = ZonedDateTime.now();
    }

    /**
     * @return Среднее значение поля minutesOfWaiting для всех элементов коллекции.
     */

    public double getAverageOfMin() {
        double averageOfMin = 0;
        int n = 0;
        for (HumanBeing human : dao.getAll()) {
            averageOfMin += human.getMinutesOfWaiting();
            n += 1;
        }
        return averageOfMin / n;
    }

    /**
     * Метод сортировки коллекции.
     */

    public void sortCollection() {
        dao.sort();
    }

    /**
     * Метод, чтобы получить коллекцию для пользователя.
     */

    public ArrayList<HumanBeing> getCollectionForUser() {
        sortCollection();
        return (dao.getAll());
    }
}
