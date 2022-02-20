package utility;

import sourse.HumanBeing;

import java.time.ZonedDateTime;
import java.util.ArrayList;



public class CollectionManager<T> {
    private ArrayList<HumanBeing> humanCollection = new ArrayList<>();
    private ZonedDateTime lastInitTime;
    private ZonedDateTime lastSaveTime;
    private FileManager fileManager;

    public CollectionManager(FileManager fileManager) {
        this.lastInitTime = null;
        this.lastSaveTime = null;
        this.fileManager = fileManager;

        loadCollection();
    }

    private void loadCollection() {
        humanCollection = fileManager.readCollection();
        lastInitTime = ZonedDateTime.now();
    }

    /**
     * @return Коллекция.
     */

    public ArrayList<HumanBeing> getCollection() {
        return (ArrayList<HumanBeing>) humanCollection;
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
        return humanCollection.getClass().getName();
    }

    /**
     * @return Размер коллекции.
     */
    public int collectionSize() {
        return humanCollection.size();
    }


    /**
     * @param id ID человека.
     * @return Человек по его ID или null, если человек не найден.
     */

    public HumanBeing getById(int id) {
        for (HumanBeing human : humanCollection) {
            if (human.equals(id)) return human;
        }
        return null;
    }


    /**
     * @param humanToFind Найти человека, чья ценность будет найдена.
     * @return Человека по его значению или null, если человек не найден.
     */

    public HumanBeing getByValue(HumanBeing humanToFind) {
        for (HumanBeing human : humanCollection) {
            if (human.equals(humanToFind)) return human;
        }
        return null;
    }

    /**
     * @return Первый элемент коллекции или null, если коллекция пуста.
     */

    public HumanBeing getFirst() {
        if (humanCollection.isEmpty()) return null;
        return humanCollection.get(0);
    }

    /**
     * @return Последний элемент коллекции или null, если коллекция пуста.
     */

    public HumanBeing getLast() {
        if (humanCollection.isEmpty()) return null;
        return humanCollection.get(humanCollection.size()-1);
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

    public void removeFromCollection(HumanBeing human) {
        humanCollection.remove(human);
    }

    /**
     * Удалить из коллекции человека, превышающего заданный.
     */

    /**
     * Очистка колекции.
     */

    public void clearCollection() {
        humanCollection.clear();
    }


    public void removeGreater(HumanBeing human) {
        Integer impactSpeed = human.getImpactSpeed();
        for(HumanBeing human1:humanCollection){
            if (human1.getImpactSpeed() > impactSpeed){
                humanCollection.remove(human1);
            }
        }
    }

    /**
     * Генерирует следующий идентификатор. Это будет (больший + 1).
     * @return Cледующий ID.
     */

    public Long generateNextId() {
        if (humanCollection.isEmpty()) return 1L;
        return humanCollection.getId() + 1L;
    }

    /**
     * Сохраняет коллекцию в файл.
     */

    public void saveCollection() {
            fileManager.writeCollection(humanCollection);
            lastSaveTime = ZonedDateTime.now();
    }

    public double getAverageOfMin() {
    double averageOfMin = 0;
    int n = 0;
    for (HumanBeing human : humanCollection) {
        averageOfMin += human.getMinutesOfWaiting();
        n += 1;
    }
    return averageOfMin/n;
    }
}

//    public int generateNextId();
//    public void sort();
//    public String getHelp();
//    public String getInfo();
//    public String show();
//    public void add(T element);
//    public void updateByID(Integer id, T newElement);
//    public void removeByID(Integer id);
//    public void clear();
//    public void save();
//    public void addIfMax(T element);
//    public void printStartsWithName(String start);
//    public boolean deserializeCollection(String json);

