package utility;

import sourse.HumanBeing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.NavigableSet;
import java.util.TreeSet;


public class CollectionManager<T> {
    private NavigableSet<HumanBeing> humanCollection =  new TreeSet<>();
    //private ArrayList<HumanBeing> humanCollection = new ArrayList<>();
    private LocalDateTime lastInitTime;
    private LocalDateTime lastSaveTime;
    private FileManager fileManager;

    public CollectionManager(FileManager fileManager) {
        this.lastInitTime = null;
        this.lastSaveTime = null;
        this.fileManager = fileManager;

        loadCollection();
    }

    private void loadCollection() {
        humanCollection = fileManager.readCollection();
        lastInitTime = LocalDateTime.now();
    }

    /**
     * @return Коллекция.
     */

    public ArrayList<HumanBeing> getCollection() {
        return humanCollection;
    }

    /**
     * @return Время последней инициализации или null, если инициализации не было.
     */

    public LocalDateTime getLastInitTime() {
        return lastInitTime;
    }

    /**
     * @return Время последнего сохранения или null, если сохранения не было.
     */

    public LocalDateTime getLastSaveTime() {
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
//TODO
    public HumanBeing getById(int id) {
        for (HumanBeing human : humanCollection) {
            if ((human.getId()).equals(id)) return human;
        }
        return null;
    }

    public HumanBeing getByValue(HumanBeing humanToFind) {
        for (HumanBeing human : humanCollection) {
            if (human.equals(humanToFind)) return human;
        }
        return null;
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
//TODO
//    public void removeGreater(HumanBeing humanToCompare) {
//        humanCollection.removeIf(human -> human. > 0);
//    }

    /**
     * Clears the collection.
     */
    public void clearCollection() {
        humanCollection.clear();
    }
     public void removeGreater(HumanBeing humanToCompare) {
        humanCollection.removeIf(human -> human.compareTo(humanToCompare) > 0);
    }

    /**
     * Generates next ID. It will be (the bigger one + 1).
     * @return Next ID.
     */
    public Long generateNextId() {
        if (humanCollection.isEmpty()) return 1L;
        return humanCollection.last().getId() + 1L;
    }

    /**
     * Saves the collection to file.
     */
    public void saveCollection() {
            fileManager.writeCollection(humanCollection);
            lastSaveTime = LocalDateTime.now();
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

